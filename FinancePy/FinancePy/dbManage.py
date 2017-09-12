__author__ = 'Administrator'


# -*- coding:utf-8 -*-
import pymysql

class dbManage(object):

    def __init__(self):
        pass


    def get_data(sqlString):
        conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='root', db='test', charset='utf8')
        cursor = conn.cursor()
        result= None
        try:
            cursor.execute(sqlString)
            row_1 = cursor.fetchone()
            result = row_1
        except:
            print("Error: unable to fetch data")
        cursor.close()
        conn.close()
        return result

    def add_data(sqlString):

        conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='root', db='test', charset='utf8')
        cursor = conn.cursor()

        cursor.execute(sqlString)
        conn.commit()
        cursor.close()
        conn.close()
        '''
        try:
            cursor.execute(sqlString)
            conn.commit()
        except:
            conn.rollback()
        cursor.close()
        conn.close()
        '''

    def update_data(sqlString):
        conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='root', db='test', charset='utf8')
        cursor = conn.cursor()
        try:
            cursor.execute(sqlString)
            conn.commit()
        except:
            print("Error: unable to update data")
            conn.rollback()
        cursor.close()
        conn.close()










'''
for i in range(1,10):
    sqlstr = "select * FROM fund WHERE id="+str(i)
    res =get_data(sqlstr)
    print(res[0],res[1],res[3])


sharesName ='鑫科材料'
ratio = float(3.690000)
rose = float(0.000000)
sharesCode='600255'
fundId=8
sql = "INSERT INTO shares(sharesCode, sharesName, ratio, rose,fundId)  VALUES ('%s', '%s', '%f', '%f' , '%d')" %  (sharesCode, sharesName, ratio, rose,fundId )
add_data(sql)

'''
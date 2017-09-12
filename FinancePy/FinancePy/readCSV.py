# -*- coding: utf8 -*-

__author__ = 'Administrator'

import csv


file = "D://1-200W.csv"
basefileName = "D://200W"
fileSuffix=".csv"


def writeCV2(filename,start,end):
    csvFile = open(file, encoding='utf-8')
    csv_reader = csv.reader(csvFile)
    with open(filename, 'w',newline='', encoding='utf-8') as csvfile:
        spamwriter = csv.writer(csvfile,dialect='excel')
        i=0
        for row in csv_reader:
            if i==0:
                spamwriter.writerow(row)
            if i>=start :
                spamwriter.writerow(row)
            if i==end:
                break
            else:
                pass
            i=i+1
    csvfile.closed
    csvFile.closed


skip=500000
for i in range(1,6):
    filename = basefileName+str(i)+fileSuffix
    print("开始 ",filename,"写入....")
    writeCV2(filename,(i-1)*skip+1,skip*i)
    print("结束 ",filename,"写入.")













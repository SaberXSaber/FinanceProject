__author__ = 'Administrator'


from concurrent.futures import ThreadPoolExecutor
import time
from FinancePy.FinancePy import dbManage
from FinancePy.FinancePy import shares

'''
def return_future_result(message):
    time.sleep(2)
    return message

pool = ThreadPoolExecutor(max_workers=2)  # 创建一个最大可容纳2个task的线程池
future1 = pool.submit(return_future_result, ("hello"))  # 往线程池里面加入一个task
future2 = pool.submit(return_future_result, ("world"))  # 往线程池里面加入一个task
print(future1.done())  # 判断task1是否结束
time.sleep(3)
print(future2.done())  # 判断task2是否结束
print(future1.result())  # 查看task1返回的结果
print(future2.result())  # 查看task2返回的结果
def exeTask(url):
    pool.submit(  )
'''

def task(i):
    sqlstr = "select * FROM fund WHERE id="+str(i)
    res =dbManage.get_data(sqlstr)
    if res is not None:
        shares.parseShare(res[3],res[0])

for i in range(580,674):
    task(i)
    # 睡眠几秒,防止访问过快网站远程关闭访问
    time.sleep(30)
'''
    if i%10==0:
        time.sleep(60)
    if i%50==0:
        time.sleep(60*10)
    if i%100==0:
        time.sleep(60*20)
'''





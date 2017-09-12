__author__ = 'Administrator'

# -*- coding:utf-8 -*-
import time
import urllib
import urllib.request
from bs4 import BeautifulSoup
from FinancePy.FinancePy import dbManage

from  collections import deque

queue =deque()
visited =set()

headers = {
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
    'Accept-Encoding': 'gzip, deflate, br',
    'Accept-Language': 'zh-CN,zh;q=0.8',
    'Cache-Control':'max-age=0',
    'Connection':'keep-alive',
    'Upgrade-Insecure-Requests':'1',
    'Cookie': 'AJSTAT_ok_pages=8; AJSTAT_ok_times=2',
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.86 Safari/537.36',
    'Host': 'www.zhihu.com',
    'Referer':'http://fuliba.net/%e6%88%91%e6%af%94%e5%a7%a8%e5%a6%88%e7%ba%a2.html'
}

baseurl="http://fund.eastmoney.com"
# url = "http://fund.eastmoney.com/GP_jzzzl.html#os_0;isall_0;ft_;pt_2"

url = "http://fund.eastmoney.com/160221.html"

shareUrl = "http://fund.eastmoney.com/f10/ccmx_160630.html"


def format(str):
    return float(str.replace("%","").replace("--","0.0"))



def parseShare(ur,fundId):
    soup=''
    try:
        html_bytes = urllib.request.urlopen(ur).read()
        html_string = html_bytes.decode('utf-8')
        soup = BeautifulSoup(html_string, 'html.parser')
    except:
        return 0
    dds = soup.find(class_='dataItem01')
    spans =  dds.findAll('span')
    estimateValue = format(spans[5].getText())
    oneMonth = format(spans[9].getText())
    oneYear=format(spans[11].getText())

    dds = soup.find(class_='dataItem02')
    spans =  dds.findAll('span')
    unitValue=format(spans[2].getText())
    threeMonth = format(spans[5].getText())
    threeYear = format(spans[7].getText())

    dds = soup.find(class_='dataItem03')
    spans =  dds.findAll('span')
    cumulativeValue=format(spans[2].getText())
    sixMonth =format(spans[4].getText())
    always =format(spans[6].getText())

    tables = soup.find(class_='infoOfFund')
    tds= tables.findAll('td')
    fundScale =format(tds[1].getText().split("：")[1].split("亿元")[0])
    fundManager=tds[2].getText().split("：")[1]
    bulidDate=tds[3].getText().split("：")[1]
    manager=tds[4].getText().split("：")[1]
    fundRating=tds[5].getText().split("：")[1]

    sql = "update fund set estimateValue='%f',oneMonth='%f',oneYear='%f',unitValue='%f',threeMonth='%f',threeYear='%f',cumulativeValue='%f'," \
          "sixMonth='%f',always='%f',fundScale='%d',fundManager='%s',bulidDate='%s',manager='%s',fundRating='%s' where id = '%d' "  % \
          (estimateValue,oneMonth, oneYear, unitValue, threeMonth,threeYear,cumulativeValue,sixMonth,always,fundScale,fundManager,bulidDate,manager,fundRating,fundId)
    print(sql)
    dbManage.dbManage.update_data(sql)

    tables = soup.find(class_='ui-table-hover')
    for tr in tables.findAll('tr'):
        tds =tr.findAll('td')
        if(len(tds)>3):
            sharesName = tds[0].getText()
            ratio = format(tds[1].getText())
            rose = format(tds[2].getText())
            sharesCode=tds[2].get('stockcode').replace("stock_","")
            #print ("sharesCode:",sharesCode,"sharesName:",sharesName," ;ratio:",ratio,";rose:",rose)
            createTime =time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
            sql = "INSERT INTO shares(sharesCode, sharesName, ratio, rose,fundId,createTime)  VALUES ('%s','%s','%f','%f','%d','%s')" %  (sharesCode, sharesName, ratio, rose,fundId,createTime )
            print(sql)
            dbManage.dbManage.add_data(sql)
    return 1




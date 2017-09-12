__author__ = 'Administrator'
# -*- coding:utf-8 -*-
import re
import urllib
import urllib.request
from bs4 import BeautifulSoup

from  collections import deque

class fund(object):

    def __init__(self):
        self.baseurl="http://fund.eastmoney.com"
        self.url="http://fund.eastmoney.com/GP_jzzzl.html#os_0;isall_0;ft_;pt_2"
        self.cnt=0
        self.queue=deque()
        self.visited=set()
        self.headers== {
            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
            'Accept-Encoding': 'gzip, deflate, br',
            'Accept-Language': 'zh-CN,zh;q=0.8',
            'Cache-Control':'max-age=0',
            'Connection':'keep-alive',
            'Upgrade-Insecure-Requests':'1',
            'Cookie': 'AJSTAT_ok_pages=8; AJSTAT_ok_times=2',
            'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.86 Safari/537.36',
            'Host': 'fund.eastmoney.com',
            'Referer':'http://fund.eastmoney.com'
        }


    def function_for(self,queue):
        for i in range(1, 10):
            queue.append(self.url+i)
            queue.append(self.url)
        return queue


    def function_while(self):
        while self.queue:
            url=self.queue.popleft()
            self.visited |= {url}
            print('已经抓取: ' + str(self.cnt) + '   正在抓取 <---  ' + url)
            self.cnt += 1
            try:
                req = urllib.request.Request(url, self.headers)
                urlop = urllib.request.urlopen(url,timeout = 2)
                if 'html' not in urlop.getheader('Content-Type'):
                    continue
                data=urlop.read().decode('utf-8')
            except:
                continue


            linkre = re.compile('href=\"(.+?)\"')
            for x in linkre.findall(data):
                if 'http' in x and x not in self.visited:
                    self.queue.append(x)
                    print('加入队列 --->  ' + x)

    def parseFund(self,url):
        # req = urllib.request.Request(url, headers)
        #urlop = urllib.request.urlopen(url,timeout = 2)
        #data=urlop.read().decode('utf-8')
        html_bytes = urllib.request.urlopen(url).read()
        html_string = html_bytes.decode('GBK')

        soup = BeautifulSoup(html_string, 'html.parser')
        tables = soup.find(class_='dbtable')
        for tr in tables.findAll('tr'):
            tds =tr.findAll('td')
            id = tds[2].getText()
            if(id.isdigit()):
                fundCode = tds[3].getText()
                fundName = tds[4].getText().replace("估值图","").replace("基金吧","").lstrip()
                detailedUrl= self.baseurl+"/"+tds[3].getText()+".html"
                dailyValue = tds[9].getText()
                dailyRate= tds[10].getText()
                applyState= tds[11].getText()
                redeemState= tds[12].getText()
                poundage= tds[13].getText()
                print ("id:",id," ;fundCode:",fundCode,";fundName:",fundName,";detailedUrl:",detailedUrl
                   ,";dailyValue:",dailyValue,";dailyRate:",dailyRate,";applyState:",applyState
                   ,";redeemState:",redeemState,";poundage:",poundage)












import urllib.parse
import urllib.request
import requests

__author__ = 'Administrator'

import os
from bs4 import BeautifulSoup
class ProxiesSpider(object):
    def __init__(self, max_page_number=10):
        self.seed = 'http://www.ip3366.net/free/'
        self.max_page_number = max_page_number # 最大页数
        self.crawled_proxies = [] # 爬到的ip,每个元素都是一个dict
        self.verified_proxies = [] # 校验过的ip
        self.headers = {
            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
            'Accept-Language': 'zh-CN,zh;q=0.8',
            'Cache-Control':'max-age=0',
            'Connection':'keep-alive',
            'Upgrade-Insecure-Requests':'1',
            'Cookie': 'AJSTAT_ok_pages=8; AJSTAT_ok_times=2',
            'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.86 Safari/537.36',
            'Host': 'www.ip3366.net'
        }
        self.tocrawl_url = []
    def crawl(self):
        self.tocrawl_url.append(self.seed)
        page_counter = 1
        while self.tocrawl_url:
            if page_counter > self.max_page_number:
                break
            # url = self.tocrawl_url.pop()
            # body = requests.get(url=url, headers=self.headers, params={'page': page_counter}).content
            # soup = BeautifulSoup(body, 'lxml')

            # values = {'page':page_counter }

            url =  self.seed+"?page="+str(page_counter)

            req = urllib.request.Request(url)

            response = urllib.request.urlopen(req)
            html_bytes = response.read()
            html_string = html_bytes.decode('gbk')
            soup = BeautifulSoup(html_string, 'html.parser')

            if soup is None:
                print('PARSE PAGE FAILED.......')
                continue
            self.parse_page(soup)
            print('Parse page %s done' % (url + '?page=' + str(page_counter)))
            page_counter += 1
            self.tocrawl_url.append(url)
        self.verify_proxies()
        self.download()

    # 解析页面并封装
    def parse_page(self, soup):

        table = soup.find('table', class_='table table-bordered table-striped')

        tr_list = table.tbody.find_all('tr')
        for tr in tr_list:
            ip = tr.contents[1].text
            port = tr.contents[3].text
            protocol = tr.contents[7].text.lower()
            url = protocol + '://' + ip + ':' + port
            self.crawled_proxies.append({url: protocol})
            print('Add url %s to crawled_proxies' % url)
        # 对ip进行校验
    def verify_proxies(self):
        print('Start verify proxies.......')
        while self.crawled_proxies:
            self.verify_proxy(self.crawled_proxies.pop())
        print('Verify proxies done.....')
    def verify_proxy(self, proxy):
        proxies = {}
        for key in proxy:
            proxies[str(proxy[key])] = key # requests的proxies的格式必须为 协议 : 地址
        try:
            if requests.get('https://www.deviantart.com/', proxies=proxies, timeout=2).status_code == 200:
                print('verify proxy success %s ' % proxies)
                self.verified_proxies.append(proxy)
        except:
            print('verify proxy fail %s ' % proxies)

        # 保存到文件中
    def download(self):
        current_path = os.getcwd()
        parent_path = os.path.dirname(current_path)
        with open(parent_path + '\proxies.txt', 'w') as f:
            for proxy in self.verified_proxies:
                for key in proxy.keys():
                    f.write(key + '\n')
if __name__ == '__main__':
    spider = ProxiesSpider()
    spider.crawl()
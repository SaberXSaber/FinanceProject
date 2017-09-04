__author__ = 'Administrator'


import xlrd
import xlwt

limit = 8

readbook = "C:\\Users\\Administrator\\Downloads\\aaaa.xls"

savebook = "C:\\Users\\Administrator\\Downloads\\bbb"



limit = int(limit)

# '/Users/huqiang/Desktop/shoplist.xls'

data = xlrd.open_workbook(readbook)
# 获取sheet
table = data.sheets()[0]
# 行数
nrows = table.nrows
# 列数
ncols = table.ncols

sheets = nrows // limit
print("sheets",sheets)

# print str(nrows) + '   ' + str(ncols)

# print table.cell(nrows - 1, ncols - 1).value


for i in range(0, sheets+1):
    print("-----------------------------------------------")
    workbook = xlwt.Workbook(encoding='ascii')

    '''
    worksheet = workbook.add_sheet(str(i))
    for row in range(0, limit):
        row_content = table.row_values(row + (i * limit))
        for col in range(0, ncols):
            worksheet.write(row, col, row_content[col])
    workbook.save(savebook+"_"+str(i)+".xls")
    '''
    worksheet = workbook.add_sheet(str(i))
    if i==sheets:
        for row in range(0, nrows % limit):
            row_content = table.row_values(row + (i * limit))
            print(row + (i * limit))
            for col in range(0, ncols):
                worksheet.write(row, col, row_content[col])
    else:
        for row in range(0, limit):
            row_content = table.row_values(row + (i * limit))
            print(row + (i * limit))
            for col in range(0, ncols):
               worksheet.write(row, col, row_content[col])
    workbook.save(savebook+"_"+str(i)+".xls")








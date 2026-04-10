import openpyxl

wb = openpyxl.load_workbook("example.xlsx")

ws1 = wb["학생 정보"]

ws1['A3'] = "손흥민"
ws1['B3'] = "002"
ws1['C3'] = "99"
ws1['D3'] = 99
ws1['E3'] = 99

wb.save("example.xlsx")


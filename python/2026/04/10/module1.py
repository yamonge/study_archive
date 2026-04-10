import openpyxl

wb = openpyxl.Workbook()
ws = wb.active
ws.title = "test_sheet1"
wb.save("example.xlsx")



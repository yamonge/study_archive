import openpyxl

wb = openpyxl.load_workbook("example.xlsx")
ws1 = wb.active
ws1.title = "학생 정보"

ws1["A1"] = '이름'
ws1["B1"] = "학번"
ws1["C1"] = "국어"
ws1["D1"] = "영어"
ws1["E1"] = "수학"

name = input("이름: ")
number = input("학번: ")
kor = int(input("국어: "))
eng = int(input("영어: "))
mat = int(input("수학: "))

ws1["A2"] = name
ws1["B2"] = number
ws1["C2"] = kor
ws1["D2"] = eng
ws1["E2"] = mat


wb.save("example.xlsx")
wb.close()

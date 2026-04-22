import csv
f = open("output", "w", encoding="utf-8", newline='')
wr = csv.writer(f)
wr.writerow([1, "안유진", False])
wr.writerow([1, "장원영", True])
f.close()
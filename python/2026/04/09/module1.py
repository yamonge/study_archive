import sys

print("명령줄 인수: ", sys.argv)

print("실행경로 : ", sys.path[0])

sys.stdout.write("Hello, World!\n")

sys.stderr.write("Error occured!\n")

sys.exit(0)
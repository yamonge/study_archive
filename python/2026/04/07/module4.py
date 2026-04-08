import sys

print("명령줄 인수: ", sys.argv)

print("실행 경로: ", sys.path[0])

sys.stdout.write("Hello, World!!\n")

sys.stdout.write("Error occurred!\n")

sys.exit(0)
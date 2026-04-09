import os

cwd = os.getcwd()
print("현재 작업 디렉토리 ", cwd)

# os.mkdir("mydir")

is_file = os.path.isfile("myfile.txt")
is_dir = os.path.isdir("mydir")
print("myfile.txt는 파일인가? ", is_file)
print("mydir은 디렉토리인가?", is_dir)

os.system("ls -l")

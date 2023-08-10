students = [i for i in range(1, 31)] # 1~30 까지의 배열을 생성

for i in range(28):
    n = int(input())
    students.remove(n)   # 하나씩 소거함으로써 과제를 안낸학생 찾아냄

print(min(students))
print(max(students))


# 접근방식
# 1. '666' 이 들어가는 숫자중 (작은 순서대로) 입력n 순서에 맞는 숫자를 찾는 문제
# 2. 666이 들어가는 숫자 찾을때 문자형으로 변경 주의!

n = int(input())

cnt = 0
result = 666

while True:
    if '666' in str(result):
        cnt += 1

    if cnt == n:
        break

    result += 1
print(result)

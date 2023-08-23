n, b = map(int,input().split())  # (60466175 36)
num="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
result=str()

while n != 0:
    result += num[n%b]   # (263 10) 이라고 했을때 나눈 나머지 = 바꾸기전 마지막자리 숫자
    n =n//b              # 몫을 새로운 n으로 재설정

result = result[::-1]
result
    

# 에라토스테네스의 체 방식 이용해서 소수를 전부 구해놓고 , tc에서 원할때 빼와서 사용 하는 방식이 시간이 훨씬 줄어들음.
#\
# 포함되어있는지 확인시 A in B 사용 ( 둘다 str 이여야함)

import math
n = 1000000
prime = []
arr = [True for i in range(n+1)]

for i in range(2,int(math.sqrt(n))+1):
    if arr[i] == True:
        j = 2
        while i * j <= n:
            arr[i*j] = False
            j += 1
for i in range(2,n+1):
    if arr[i] == True:
        prime.append(i)


tc = int(input())
for test_case in range(1,tc+1):
    cnt = 0
    D, A, B = map(int, input().split())
    str_D = str(D)


    for pr in prime:
        if pr >= A and pr <= B:
            if str_D in str(pr):
                cnt += 1
    print(f"#{test_case} {cnt}")

# 접근 방식
# 1. 단위의 뒤(큰단위) 부터 나눠내려가기
# 2. 항상 이게 맞는건 아님 (단위에 따라 달라질 수 있음!)

n,m = map(int,input().split())


unit=[]
for i in range(n):
    unit.append(int(input()))

count = 0
for i in range(n):
   coin = (unit[-i-1])
   count += (m // coin)
   m = (m % coin)
print(count)

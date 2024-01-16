# 삼각형의 조건 : 가장 긴 변은 나머지 두 변의 합보다 작아야 한다.

a,b,c = map(int,input().split())

if max(a,b,c) >= (a+b+c) -max(a,b,c):
    d = ((a+b+c)-max(a,b,c)) -1
    print(((a+b+c)-max(a,b,c)) + d)
else:
    print(a+b+c)

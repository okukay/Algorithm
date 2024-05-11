## (등차수열) b-a = c-b     
##         즉 2b = a + c
## b는 2배로 늘어나기 때문에 무조건 b를 조절하는것이 최소의 수로 조절할 수 있는 방법임



tc = int(input())
for test_case in range(1,tc+1):

    a,b,c = map(int,input().split())

    if 2 * b == a + c:
        print(f"#{test_case} {0.0}")
    else:
        print(f"#{test_case} {abs((2 * b) - (a+c))/2}")

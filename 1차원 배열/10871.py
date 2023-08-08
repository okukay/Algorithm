a,b = map(int, input().split())
c = list(map(int, input().split()))

for i in range(c):
    if i < b:
        print(i, end=" ")

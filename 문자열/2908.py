a,b = input().split()
a = int(a[::-1])   # 역순으로 바꾸기 [::-1]
b = int(b[::-1])

if a > b:
    print(a)
else:
    print(b)

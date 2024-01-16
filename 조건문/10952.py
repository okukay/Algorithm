while True:   # True or 1 로 두면 무한루
    a, b = map(int, input().split())
    if (a==0 and b==0):
        break
    else:
        print(a+b)
        

while 1: 
    try:
        a, b = map(int, input().split())
        print(a+b)
    except:                # try에 에러가 나면 break
             break

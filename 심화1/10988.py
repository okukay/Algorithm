word = list(str(input()))

if word[::1] == word[::-1]:   # 기본순서 == 역순 
    print(1)
else:
    print(0)

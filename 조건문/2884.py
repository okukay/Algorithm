hour,min = map(int,input().split())

if min < 45:
    if hour == 0:
        hour = 23
    else:
        hour = hour -1
    min= min + 15  
elif min >= 45:
     min = min -45
print(hour, min)

# 45분 전이라 함은 = 60-45 =15 를 원래 분에 더하서 min구하기

hour,min = map(int,input().split())
timer = int(input())

hour = hour + timer // 60   # timer 몫 더해줌
min = min + timer % 60      # timer 나머지 더해줌

if min >= 60:               # 그래도 min 이 60이 넘을경우 
    hour = hour +1
    min = min -60

if hour >= 24:
    hour = hour -24
print(hour,min)

// 또는 

hour,min = map(int,input().split())
timer = int(input())

min = min + timer

if min >=60:
    hour = hour + (min // 60)
    min =  (min % 60)
if hour >= 24 :
    hour = hour -24
print(hour,min)

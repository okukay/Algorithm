M= int(input())
N= int(input())
if M == 1:                       # 1은 소수가 아니기 때문에 M=1 이 오면 +1 해줌
    M = M+1
arr =[]
for num in range(M,N+1):         
    count = 0
    for i in range(2,num):
     if num % i == 0:
        count += 1
    if count == 0:
        arr.append(num)           # num에 i를 나눠서 나머지가 0이면 count를 추가하고, 즉, count가 0인게 소수인것, //arr리스트에 추가
if len(arr) == 0:                 # len(arr) 사용 = 소수가 아무것도 없는것 찾기
    print("-1")
else:
    print(arr)
    print(sum(arr))
    print(min(arr))

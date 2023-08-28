n = int(input())
number = map(int, input().split())

count = 0 
for num in number:
    if num > 1:
        a = 0
        for i in range(2, num):
            if num % i == 0:
                a += 1
        if a == 0:
            count += 1

print(count)

# ex) number  = 7 이라고 하면, 1과 7을 제외한 2,3,4,5,6 를 나누기로 사용해서 나머지가 0인걸 찾고
# 소수가 있으면 a 에 1을 더한다 
# 즉 a에 아무값도 더해지지 않으면 1과 자신으로만 나눠지는 소수인것 이다

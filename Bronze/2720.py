coin = [25, 10, 5, 1]
T = int(input())

for _ in range(T) :
    n = int(input())
    result = []

    for i in coin :
        result.append(n // i) # 몫이 해당 단위의 개수
        n = n % i	# 나머지는 다시 n에 저장
        
    print(*result)	# 리스트 앞에*  = unpacking ("리스트의 포장을 풀어준다")


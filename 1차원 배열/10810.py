N, M = map(int, input().split())
basket = [0] * (N+1) # 바구니를 전부 0으로 초기화 


for i in range(M):
    i, j, k = map(int, input().split())
    for n in range(i, j+1):
        basket[n] = k

for i in range(1, N+1):
    print(basket[i], end = ' ')

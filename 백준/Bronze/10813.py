N,M= map(int, input().split())
basket = [i for i in range(1, N+1)] # 바구니를 1 ~ N 값으로 초기화 

for i in range(M):
    i,j = map(int, input().split())
    temp = basket[i-1]     # 박스 두개 값 서로 바꾸는 코드 temmp 사용
    basket[i-1] = basket[j-1]
    basket[j-1] = temp

for i in range(N):
    print(basket[i], end =" ")


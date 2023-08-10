N,M = map(int, input().split())
basket = [i for i in range(1,N+1)]

for i in range(M):
    i,j = map(int,input().split())
    temp = basket[i-1:j]  # 선택한 부분 temp로 지정
    temp.reverse()  # 뒤집기 reverse 함수 사용
    basket[i-1:j] = temp

for i in range(N):
    print(basket[i], end =" ")


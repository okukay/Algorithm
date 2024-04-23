# 백트레킹 문제

N = int(input())
T = [0] * N
P = [0] * N

def dfs(n,sm):
    global ans
  
  # 종료조건
    if n >= N:
        ans = max(ans,sm)
        return
      
  # 상담을 한다면, 그다음 dfs(현재날짜 + 소요시간, 현재금액+ 수익)
    if n+T[n] <= N:
        dfs(n+T[n], sm+P[n])
      
  # 상담을 안할시, 다음dfs() 호출
    dfs(n+1,sm)

for i in range(N):
    T[i], P[i] = map(int,input().split())

ans = 0
dfs(0,0)
print(ans)

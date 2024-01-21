# 점프 문제
# 첫줄부터 좌 -> 우 로 탐색하여
# dp > 0 이라면 이동해서 왔다는 뜻, 
# 

N = int(input())

arr = [list(map(int,input().split()))for _ in range(N)]
dp = [[0]*N for i in range(N)]
dp[0][0] = 1

for i in range(N):
    for j in range(N):
        if dp[i][j] > 0 and arr[i][j] > 0:
            jump = arr[i][j]
          
            if j + jump < N:                # 우측 방향
                dp[i][j+jump] += dp[i][j]
              
            if i + jump < N:                # 아래 방향
                dp[i + jump][j] += dp[i][j]
            
print(dp[N-1][N-1])

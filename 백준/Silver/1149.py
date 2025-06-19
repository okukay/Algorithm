# RGB거리 문제
# DP 문제

# DP 테이블을 만든후
# 1번째 집에 빨강을 선택했을 경우 2번째집에서 파랑, 초록 중 작은값을 DP 테이블에서 최신화 시켜 나가기 

N = int(input())

arr = [list(map(int,input().split()))for _ in range(N)]
dp = [arr[0][:]]+[[0]*3 for _ in range(N-1)]            # [첫줄은 arr 나머지는 0으로 초기화]


for i in range(1,N):
    for j in range(3):
        if j == 0:
            dp[i][j] = arr[i][j] + min(dp[i - 1][j + 1], dp[i - 1][j + 2])
        if j == 1:
            dp[i][j] = arr[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j + 1])
        if j == 2:
            dp[i][j] = arr[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j - 2])

print(min(dp[N-1]))

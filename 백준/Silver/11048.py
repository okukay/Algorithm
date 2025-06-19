# 이동하기 문제

# 사탕이 들어있는 arr를 만들기
# 0으로된 DP 테이블을 만들기
# 갈수있는 세방향( 오른쪽아랫대각선, 우측, 아래) 중 max값 + 사탕테이블중 방문할 방 더해서 =  dp테이블 완성
# 최종적으로  (N, M) 의 값 출력

N,M = map(int,input().split())


arr = [[0]*(M+1)]+[[0]+list(map(int, input().split())) for _ in range(N)]   # 젤 윗줄 0으로 패딩 , 각열마다 앞에 0넣어주기

dp = [[0]*(M+1) for _ in range(N+1)]


for i in range(1,N+1):
    for j in range(1,M+1):
        dp[i][j] = arr[i][j] + max(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])  
print(dp[N][M])

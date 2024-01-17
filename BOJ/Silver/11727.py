# 타일링 2 문제

# 그림을 그려보고 규칙을 찾아야함

# n = 1 일때 그림
# n = 2 일때 그림
# n = 3 일때 그림
    ...


N = int(input())

dp = [0] * (N+1)
dp[0] = 1
dp[1] = 1

for i in range(2,N+1):
    dp[i] = dp[i-1] + dp[i-2]*2  
    # dp[i-1]인 그림 우측에 (1x2)하나씩 추가  + dp[i-2]인 그림 우측에 추가

result = dp[N]
print(result % 10007)

# 타일링 문제 
# dp 문제

# 규칙 찾기 : n 번째 값은 = (n-1) + (n-2) 값이랑 같음

# N이 1일때, 2일때 인덱스에러 발생 주의! (그래서 if else문 사용)

N = int(input())
dp = [0]* (N+1)


if N < 3:
    print(N % 10007)
else:
    dp[1] = 1
    dp[2] = 2
    for i in range(3,N+1):
        dp[i] = dp[i-1] + dp[i-2]

    result = dp[N]
    print(result % 10007)

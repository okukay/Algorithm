# 오르막수 문제
#1차원으로 풀이

# 표를 그려서 규칙을 찾음 ( 규칙 : j자리부터 끝까지 더하면 그 자리의 개수가 나옴)

N = int(input())

dp = [1]*10

for _ in range(2,N+1):
    for j in range(0,10):
        dp[j] = sum(dp[j:])

result = sum(dp)

print(result % 10007)

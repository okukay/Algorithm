# 1,2,3더하기 문제 

# dp[4] 의 개수 = dp[1]+dp[2]+dp[3] 의 개수  
# n번째면 = n앞에 3개의 합 
# 규칙 찾아야함

n = int(input())

arr = [0] * 11
arr[1] = 1
arr[2] = 2
arr[3] = 4

for i in range(4,11):
    arr[i] = arr[i-1] + arr[i-2] + arr[i-3]

for j in range(n):
    result = int(input())
    print(arr[result])

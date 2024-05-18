# 백트래킹 문제
# 각 열에 따라 한명씩 일이 가능함 , 열별로 봤을때 중복이 없어야함  = v[] 배열 사용
# v[] 방문하지 않았다면 1을 해주고, dfs() 호출후 v[]에 0으로 원상복구 시켜놓아야함


def dfs(n,sm):
    global ans
    if ans >= sm:
        return
    if n == N:
        ans = max(ans,sm)
        return

    for j in range(N):
        if v[j] == 0:
            v[j] = 1
            dfs(n+1,sm * (arr[n][j]/100))
            v[j] = 0

tc = int(input())
for test_case in range(1,tc+1):

    N = int(input())
    arr = [list(map(int,input().split())) for _ in range(N)]

    ans = 0
    v = [0] * N
    dfs(0,100)
    print(f"#{test_case} {ans:.6f}")

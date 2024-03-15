# 백트래킹(dfs) 문제
# 전부다 탐색

def dfs(n,sm):
    global ans
    if n ==N:
        if sm == K:
            ans += 1
        return

    dfs(n+1, sm+arr[n])
    dfs(n+1,sm)


tc = int(input())
for test_case in range(1,tc+1):
    N,K = map(int,input().split())
    arr = list(map(int,input().split()))
    ans = 0
    dfs(0,0)

    print(f"#{test_case} {ans}")

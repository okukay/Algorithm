# 백트래킹 으로 해결

def dfs(n,num,ci,cj):
    if n == CNT:
        arr_set.add(num)
        return

    for di,dj in (-1,0),(1,0),(0,-1),(0,1):
        ni,nj = ci+di , cj+dj
        if 0<= ni <N and 0<=nj<N:
            dfs(n+1,num*10+arr[ni][nj],ni,nj)

tc =int(input())
for test_case in range(1,tc+1):

    N = 4
    CNT = 7
    arr = [list(map(int,input().split())) for _ in range(N)]

    arr_set = set()
    for si in range(N):
        for sj in range(N):
            dfs(1,arr[si][sj],si,sj)
    ans = len(arr_set)
    print(f"#{test_case} {ans}")

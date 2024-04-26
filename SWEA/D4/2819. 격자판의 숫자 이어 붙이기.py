# 백트래킹 으로 해결

def dfs(n,num,ci,cj):
    # 종료조건을 항상 우선 (결과값)
    if n == CNT:
        arr_set.add(num)                        # 중복을 제외한 개수를 세야해서 set() 사용
        return

    for di,dj in (-1,0),(1,0),(0,-1),(0,1):
        ni,nj = ci+di , cj+dj
        if 0<= ni <N and 0<=nj<N:
            dfs(n+1,num*10+arr[ni][nj],ni,nj)        # 이어붙이는데 맨뒷자리에 와야하기 때문에 x10을 해주고, 일의자리를 더해준다

tc =int(input())
for test_case in range(1,tc+1):

    N = 4
    CNT = 7
    arr = [list(map(int,input().split())) for _ in range(N)]

    arr_set = set()
    for si in range(N):
        for sj in range(N):
            dfs(1,arr[si][sj],si,sj)            # 모든 자리를 돌면서 dfs()를 전부 호출 시켜야함
    ans = len(arr_set)
    print(f"#{test_case} {ans}")

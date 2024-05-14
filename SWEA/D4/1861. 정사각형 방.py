## bfs로 풀이 

def bfs(si,sj):
    q = []
    q.append((si,sj))
    cnt = 1
    while q:
        ci,cj = q.pop(0)

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di,cj+dj
            if 0<= ni < N and 0<= nj <N and arr[ni][nj] == arr[ci][cj] + 1:
                q.append((ni,nj))
                cnt += 1
    return cnt
tc = int(input())
for test_case in range(1,tc+1):

    N = int(input())
    arr = [list(map(int,input().split()))for _ in range(N)]
    num = 0
    max_cnt = 0
    for i in range(N):
        for j in range(N):
            result = bfs(i,j)
            if max_cnt < result:
                max_cnt = result
                num = arr[i][j]
            elif max_cnt == result:
                if num > arr[i][j]:
                    num = arr[i][j]

    print(f"#{test_case} {num} {max_cnt}")

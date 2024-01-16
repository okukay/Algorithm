# 접근방법
# BFS 방식 사용
# 상하좌우를 조건에 맞춰서 이동하여 v[ni][nj]를 계속 최신화 시킴 +1 씩
# 마지막으로 append()한 위치를 pop()해서 = (ci,cj)
# 이게 bfs함수를 사용시 매개변수에 있는 (ei,ej) 즉, 도착위치와 같으면 return 

def bfs(si, sj, ei, ej):
    q = []
    v = [[0]*M for _ in range(N)]

    q.append((si,sj))
    v[si][sj] = 1

    while q:
        ci,cj = q.pop(0)
        if (ci, cj) == (ei, ej):
            return v[ei][ej]

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di , cj+dj
            if 0<=ni<N and 0<=nj<M and arr[ni][nj] == 1 and v[ni][nj] == 0:
                q.append((ni,nj))
                v[ni][nj] = v[ci][cj]+1

N, M = map(int, input().split())
arr = [list(map(int,input()))for _ in range(N)]

result = bfs(0,0,N-1,M-1)
print(result)

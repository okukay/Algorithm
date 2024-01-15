# 빙산 문제

# a_sub = 0으로된 2차배열 생성 ( 빙산에 접한 물의 수를 카운트)

# slove() =  
#            [1. 네방향의 0 카운트] // 0 이아닌 빙산이 있는 좌표를 찾아서, 상하좌우를 비교하여, 0이면 빙산좌표랑 같은 a_sub좌표에 +1씩 해줌

#            [2. 높이 낮추기] // 처음부터 순회하며, a_sub >0 즉 주위에 물이 있었던 좌표를 찾고, max(0,[빙산크기 - a_sub]) 해서 높이를 낮추고 , 마이너스가 될경우 0이 되도록(arr 조건때문에)

#            [3.덩어리 개수 카운트] // bfs() 실행 , 연결된 빙하의 좌표 v를 1로 바꿔버리고 cnt += 1 해버림, 또 bfs()가 실행된다면, 연결되지 않았던 빙산 덩어리 이다.


from collections import deque

def bfs(si,sj,v):
    q= deque()

    q.append((si,sj))
    v[si][sj] =1

    while q:
        ci,cj = q.popleft()
        for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            ni,nj = ci+di,cj+dj
            if v[ni][nj] == 0 and arr[ni][nj] >0:
                q.append((ni,nj))
                v[ni][nj] = 1

def solve():
    for year in range(1, 900000):
        a_sub = [[0] * M for _ in range(N)]  # 모두 0으로된 배열생성

        # [1] 네방향의 0 카운트
        for i in range(1, N - 1):            # 하나씩 전부 검사(빙산인지 물인지),
            for j in range(1, M - 1):        # 가장자리는 물이라고 했기 때문에 가장자리 제외
                if arr[i][j] == 0:           # 0이면 물
                    continue
                for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                    ni, nj = i + di, j + dj
                    if arr[ni][nj] == 0:
                        a_sub[i][j] += 1

        # [2] 높이 낮추기
        for i in range(1, N - 1):
            for j in range(1, M - 1):
                if a_sub[i][j] > 0:
                    arr[i][j] = max(0, arr[i][j] - a_sub[i][j])


        # [3] 덩어리 개수 카운트
        v = [[0] * M for _ in range(N)]
        cnt = 0
        for i in range(1, N - 1):                        # 빙산을 찾기위해 돌기
            for j in range(1, M - 1):
                if v[i][j] == 0 and arr[i][j] > 0:       # 그중에 v가 방문하지 않았고 arr가 빙산일 경우에
                    bfs(i, j, v)                         # bfs실행 bfs를 실행함으로 연결된 빙하의 좌표 v를 1로 바꿔버림
                    cnt += 1                             # 그러므로 한번실행할때 연결된 빙하는 전부 1이 되고 , cnt+=1
                if cnt > 1:                              # 다음번에 또 bfs가 실행되면 = 다른 빙하 덩어리
                    return year
        if cnt == 0:
            return 0

N,M = map(int,input().split())
arr = [list(map(int,input().split()))for _ in range(N)]

result = solve()
print(result)

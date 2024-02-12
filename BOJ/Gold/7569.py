# 문제 : 토마토문제 

# BFS 사용, 3차원 배열

# 총며칠이 걸렸는지 = 방문할때마다 +1 씩해주기

# 3중 for문을 돌면서 1(익었으면) q에 추가하고
# 0(안익었으면) cnt를 +1 해준다 왜냐? 총 0의 개수만큼 cnt가 올라가게 되고 bfs를 한번 진행할때마다 cnt 를 -1해주게 되고
# cnt 가 0이되면 0이 전부 1로 전환이 됬다는 소리 = 모두가 익었다는 소리 


# 일반 큐를 사용했는데 시간초과 에러뜸 = deque 사용해서 해결



from collections import deque
def bfs():
    q = deque()
    v = [[[0] * M for _ in range(N)] for _ in range(H)]

    cnt = 0
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if arr[h][i][j] == 1:
                    q.append((h,i,j))
                    v[h][i][j] = 1
                elif arr[h][i][j] == 0:
                    cnt += 1
    while q:
        ch,ci,cj = q.popleft()

        for dh,di,dj in ((0,-1,0),(0,1,0),(0,0,-1),(0,0,1),(-1,0,0),(1,0,0)):
            nh,ni,nj = ch+dh, ci+di, cj+dj
            if 0 <= nh < H and 0 <= ni < N and 0 <= nj < M and v[nh][ni][nj] == 0 and arr[nh][ni][nj] == 0:
                q.append((nh, ni, nj))                          #미방문시                 # 안익은 토마토면
                v[nh][ni][nj] = v[ch][ci][cj] + 1
                #다음좌표를 그전좌표에서 +1 해준다  = 총 얼마나 걸렸는지 확인하기 위해 사용
                cnt -=1
    if cnt == 0:
        return v[ch][ci][cj]-1
    else:
        return -1



M,N,H = map(int,input().split())
arr = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

result = bfs()
print(result)

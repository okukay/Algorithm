# 토마토 문제 (2인칭)

# 7569 문제에서 높이만 뺀 버전
# 이중 for문으로 전부 q에 넣어놓고 시작하면  시작점이 2곳이라도 양쪽에서 bfs가 실행되는 효과를 누릴수 있음

from collections import deque
def bfs():
    cnt = 0
    q = deque()
    v = [[0] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if arr[i][j] == 1:
                q.append((i,j))
                v[i][j] = 1

            elif arr[i][j] == 0:
                cnt += 1

    while q:
        ci,cj = q.popleft()

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di,cj+dj
            if 0<=ni<n and 0<=nj<m and arr[ni][nj] == 0:
                q.append((ni,nj))
                arr[ni][nj] = arr[ci][cj] +1
                cnt -= 1
              
    if cnt == 0:
        return arr[ci][cj] -1
    else:
        return -1

m,n = map(int,input().split())
arr = [list(map(int,input().split()))for _ in range(n)]

result = bfs()
print(result)

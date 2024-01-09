# 단지번호붙이기 문제
# BFS 사용 (DFS도 가능)
# 이중 for문 사용하여 jido가 1이면서, 방문하지 않은곳을 찾아 bfs함수 적용
# bfs 함수는 방문한 곳의 수를 return
# seq = '\n' 사용 (숫자 사이사이에 줄바꿈 넣음)


def bfs(si,sj):
    q = []

    q.append((si,sj))
    v[si][sj] = 1
    cnt = 1

    while q:
        ci,cj = q.pop(0)
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni, nj = ci+di, cj+dj
            if 0<=ni<N and 0<=nj<N and jido[ni][nj] == 1 and v[ni][nj] == 0:
                q.append((ni,nj))
                v[ni][nj] = 1
                cnt += 1
    return cnt

N = int(input())
jido = [list(map(int,input()))for _ in range(N)]

v = [[0]*N for _ in range(N)]
result = []
for i in range(N):
    for j in range(N):
        if jido[i][j] == 1 and v[i][j] == 0:
            result.append(bfs(i,j))

result.sort()

print(len(result), *result, sep = '\n')

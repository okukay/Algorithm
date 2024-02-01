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
            if 0<=ni<N and 0<=nj<N and jido[ni][nj] == 1 and v[ni][nj] == 0:        # 조건에 부합하면 V배열에 1을 추가하면서 
                q.append((ni,nj))                                                   # cnt +=1 해준다 = 한단지에 몇개를 돌았는지 확인하기 위해
                v[ni][nj] = 1
                cnt += 1
    return cnt

N = int(input())
jido = [list(map(int,input()))for _ in range(N)]

v = [[0]*N for _ in range(N)]
result = []
for i in range(N):
    for j in range(N):
        if jido[i][j] == 1 and v[i][j] == 0:       # 지도에서 1이면서 v배열이 0 (방문안했던 곳) 이면 BFS실행
            result.append(bfs(i,j))                # 최종값 : BFS한 결과를 result에 추가, sort해서 출력

result.sort()

print(len(result), *result, sep = '\n')

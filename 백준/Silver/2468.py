# 안전 영역 문제 (두번째 풀이중)

# bfs함수, solve함수 두개 만들어서 사용

# h범위 (1~100) 까지를 돌면서 slove함수를 통해 값을 찾고 최대값으로 최신화를 시켜나가는 형식
#     (높이는 주어지지 않고 H가 1~100중 하나 일때 안전영역이 최대로 많이 나올수 있는걸 찾는 문제)

# slove() = 2차원배열 돌면서, 방문하지 않았고, 높이 h보다 높으면 안전 영역이다 판단되어 bfs()함수 실행


from collections import deque
def bfs(si,sj,h):
    q= deque()

    q.append((si,sj))
    v[si][sj] = 1

    while q:
        ci,cj = q.popleft()
        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di, cj+dj
            if 0<=ni<N and 0<=nj<N and v[ni][nj] == 0 and arr[ni][nj] > h:
                q.append((ni,nj))
                v[ni][nj] =1

def solve(h): # h높이에 잠기지 않는 영역 찾아서 bfs()실행
    cnt = 0
    for i in range(N):
        for j in range(N):
            if v[i][j] == 0 and arr[i][j] > h:
                bfs(i,j,h)
                cnt += 1
    return cnt

N = int(input())
arr = [list(map(int,input().split()))for _ in range(N)]

result = 0
for h in range(100):
    v = [[0] * N for _ in range(N)]
    result = max(result, solve(h))
print(result)

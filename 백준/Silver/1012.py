# 유기농 배추 문제

# 배추휜지렁이가 얼마나 필요한지 = 배추덩어리가 몇개인지 = bfs가 몇번 실행됬는지
# bfs실행마다 cnt +=1 해주면서 해결

def bfs(si,sj):
    q= []
    q.append((si,sj))
    arr[si][sj] = 0

    while q:
        ci,cj = q.pop(0)

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni , nj  = di+ci , dj+cj
            if 0<=ni<n and 0<=nj<m and arr[ni][nj] == 1:
                q.append((ni,nj))
                arr[ni][nj] = 0

tc = int(input())
for _ in range(tc):
    m,n,k = map(int,input().split())
    arr = [[0]*(m) for _ in range(n)]

    for i in range(k):                  # 배추가 심어진 곳 좌표따라 1로 표시 해주기 
        i,j = map(int,input().split())
        arr[j][i] = 1

    cnt = 0                             # m 이 가로길이(10)  j 가 10
    for i in range(n):                  # n 이 세로길이 (8)  i 가 8
        for j in range(m):
            if arr[i][j] == 1:
                bfs(i,j)
                cnt += 1
    print(cnt)

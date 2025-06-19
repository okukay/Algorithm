# 적록색약 문제
# 정상 bfs, 색약 bfs 따로 만들어서 동시에 실행하도록 설계


def bfs(si,sj,color):
    global cnt
    q = []
    q.append((si,sj))
    v[si][sj] = 1
    while q:
        ci,cj = q.pop(0)

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di,cj+dj
            if 0<=ni<n and 0<=nj<n and v[ni][nj] ==0 and arr[ni][nj] == color:
                q.append((ni,nj))
                v[ni][nj] = 1
    cnt +=1


def bfs_2(si,sj,color):
    global cnt_2
    q = []
    q.append((si,sj))
    v_2[si][sj] = 1
    while q:
        ci,cj = q.pop(0)

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di,cj+dj
            if 0<=ni<n and 0<=nj<n and v_2[ni][nj] ==0:
                if arr[ni][nj] == color:
                    q.append((ni,nj))
                    v_2[ni][nj] = 1
                elif (color == "R" and arr[ni][nj] == "G") or \
                        (color == "G" and arr[ni][nj] == "R"):
                    q.append((ni, nj))
                    v_2[ni][nj] = 1
    cnt_2 +=1

n = int(input())
arr = [list(input())for _ in range(n)]
v = [[0] * n for _ in range(n)]
v_2 = [[0] * n for _ in range(n)]
cnt = 0
cnt_2 =0

for i in range(n):
    for j in range(n):
        if v[i][j] == 0:
            bfs(i,j,arr[i][j])

        if v_2[i][j] == 0:
            bfs_2(i,j,arr[i][j])

print(cnt,cnt_2)

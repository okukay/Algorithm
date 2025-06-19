# 영역 구하기 문제
# 
# (왼쪽아래꼭짓점 x값) - (오른쪽위 꼭짓점 x값) 
# (왼쪽아래꼭짓점 y값) - (오른쪽위 꼭짓점 y값) 

def bfs(si,sj):
    q=[]
    q.append((si,sj))
    arr[si][sj] = 0
    size = 1
    while q:
        ci,cj = q.pop(0)

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = di+ci, dj+cj
            if 0<=ni<n and 0<=nj<m and arr[ni][nj] ==1:
                q.append((ni,nj))
                arr[ni][nj] = 0
                size += 1
    return size                        # 하나의 영역마다 size 체크해서 return

m,n,k = map(int,input().split())
arr = [[1] * m for _ in range(n)]
for _ in range(k):                        
    a,b,c,d = map(int,input().split())    # 이부분이 좌표를 받아서 그 좌표 사각형 만큼 0으로 채우기 
    for i in range(abs(b-d)):             # 
        for j in range(abs(a-c)):         #
            arr[a+j][b+i] = 0
cnt =0
result =[]
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            result.append(bfs(i,j))    # bfs를 실행할때마다 size를 result 리스트에 추가해주기 
            cnt +=1                    # bfs가 실행될때마다 카운트를 해주면 = 몇개의 덩어리가 있는지 확인이 가능함

result.sort()
print(cnt)
print(*result)

# 그림 문제

# bfs로 풀이
# bfs를 실행할때마다 size를 체크해서 return 
# bfs를 실행할때마다 return 되는 결과를 result 리스트에 저장하기 

# len() 하면 = bfs를 몇번 실행했는지를 알 수 있고
# max () 하면 = 값중 젤큰 그넓이를 구할 수 있음

def bfs(si,sj):
    size = 0
    q = []

    q.append((si,sj))
    v[si][sj] = 1

    while q:
        ci,cj = q.pop(0)

        for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
            ni,nj = ci+di, cj+dj
            if 0<=ni<n and 0<=nj<m and arr[ni][nj] == 1:
                q.append((ni,nj))
                arr[ni][nj] = 0
                size +=1
    if size == 0:                # 그림이 1개인 경우에 위의 if문을 만족할 수 없기때문에 그림이 1개임에도 불구하고 0이 출려고된다 
        size += 1                # 그래서 size 0이면 +1해주는 구문 넣음 (이거말고 더 깔끔한 코드를 찾고싶은데,, 해결이 안됨) 
    else:
        size
    return size



n,m = map(int,input().split())
arr = [list(map(int,input().split()))for _ in range(n)]
v = [[0] * m for _ in range(n)]


result = []
for i in range(n):                  
    for j in range(m):              
        if arr[i][j] == 1:
            result.append(bfs(i,j))


if len(result) == 0:
    print(0)
    print(0)
else:
    print(len(result))
    print(max(result))

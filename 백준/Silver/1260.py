# 접근방식
# [필요 리스트] 1. V(방문했는지 확인용 리스트 (0,1 들어감)) 2. adj(입력을 이차배열로 받아 넣는 리스트 (양방향)), 3. ans(방문한 순서를 나타낼 = 결과 리스트)  

# dfs(깊이우선 탐색= 한쪽으로 깊게 탐색) = 방문결과 ans에 추가하면서, 방문했으면 V[c]에도 추가 안했으면 dfs(s) 함수 다시 실행 ... 반복해서 v[c]가 전부 1이 되면 마침

# bfs(너비우선 탐색 = 넓게 탐색) = q[] 생성, 큐를 이용해서 dfs랑 똑같이 실행 ... q를 전부 pop해서 없을때 마침

def dfs(c):
    ans_dfs.append(c)   # 방문 노드 추가
    v[c] = 1            # 방문 표시

    for n in adj[c]:
        if v[n] == 0:    # 방문하지 않은 노드인 경우
            dfs(n)

def bfs(s):
    q = []              # 필요한 q, v[], 변수 생성

    q.append(s)         # q에 초기데이터(들) 삽입
    ans_bfs.append(s)
    v[s] = 1

    while q:
        c = q.pop(0)
        for n in adj[c]:
            if v[n] == 0:    # 방문하지 않은 노드=> 큐 삽입
                q.append(n)
                ans_bfs.append(n)
                v[n] = 1


# [2] adj에 값넣어주기 (양방향)
N, M, V = map(int, input().split())
adj = [[] for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)    


# [2] 오름차순 정렬
for i in range(1, N+1):
    adj[i].sort()

# dfs 실행
v = [0]*(N+1)
ans_dfs = []
dfs(V)                 

# bfs 실행
v = [0]*(N+1)
ans_bfs = []
bfs(V)

print(*ans_dfs)
print(*ans_bfs)



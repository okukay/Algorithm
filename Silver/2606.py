# 접근방식
# DFS 사용
# 바이러스 걸리는 수 = DFS로 방문한 집의 수
# 방문 순서 출력을 리스트로 unpacking 해서 len() 해주기.

def dfs(c):
    result.append(c)
    v[c] = 1

    for i in network[c]:
        if v[i] == 0:
            dfs(i)


N = int(input())
M = int(input())

network = [[] for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    network[s].append(e)
    network[e].append(s)

for i in range(1, N+1):
    network[i].sort()

v = [0]*(N+1)
result = []
dfs(1)
print(len([*result])-1)

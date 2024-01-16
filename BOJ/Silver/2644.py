# 촌수계산 문제
# bfs 이용

def bfs(A,B):
        q = []
        v= [0] *(N+1)

        q.append(A)
        v[A] = 1

        while q:
            c = q.pop(0)
            if c == B:
                return v[B]-1   # 시작부터 1을 넣었으니 -1해주기
                                # 나랑 한칸 떨어져있으면 1촌
            for i in adj[c]:
                if v[i] == 0:
                    q.append(i)
                    v[i] += v[c]+1
        return -1

N = int(input())
A,B = map(int,input().split())
M = int(input())

adj = [[] for _ in range(N+1)]
for _ in range(M):
    s,e = map(int,input().split())
    adj[s].append(e)
    adj[e].append(s)

for i in range(1, N+1):
    adj[i].sort()

result = bfs(A,B)
print(result)

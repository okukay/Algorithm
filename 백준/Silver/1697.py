# 문제 : 숨바꼭질
#
# BFS 사용
# 나의 위치를 최상위 노드로 두고 C-1, C+1, C*2 로 가지를 쳐서 트리를 만들어보고
# 방문할 거리를 BFS로 측정


def bfs(s,e):
    q = []
    v = [0]* 200000

    q.append(s)
    v[s] = 1

    while q:
        c = q.pop(0)
        if c == e:        # while문을 돌면서 if c==e 계속해주는데 젤 처음 return 된값이 젤 최소(빠른)시간
            return v[e]-1

        for i in (c-1,c+1,c*2):
            if 0<=i<=200000 and v[i] == 0:
                q.append(i)
                v[i] = v[c]+1              #  몇번을 이동했는지 알아야 하기 때문에 = +1 을 해줌
    return -1
N,M = map(int,input().split())

result = bfs(N,M)
print(result)

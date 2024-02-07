# 맥주 마시면서 걸어가기 문제

# 편의점만 v[] 배열을 만들어주고 방문하면서 마지막 편의점부터 , 최종목적지 까지의 거리가 1000이하라면 happy 하게 풀이



def bfs(sj, si, ej, ei):
    q = []
    v = [0] * N

    q.append((sj, si))

    while q:
        cj, ci = q.pop(0)
        if abs(cj - ej) + abs(ci - ei) <= 1000:          # 편의점에서 목적지 까지 거리가 1000이하 라면 happy
            return "happy"
            
        for i in range(N):
            if v[i] == 0:                                    # 편의점방문
                nj, ni = lst[i]                              # 다음 좌표가 = 편의점좌표[i]
                if abs(cj - nj) + abs(ci - ni) <= 1000:      # 현재 거리 에서 다음 거리까지 가 1000 이하이면 이동가능하여, append 해줌
                    q.append((nj, ni))
                    v[i] = 1
    return "sad"


TC = int(input())
for _ in range(TC):
    N = int(input())                            # 편의점 개수
    sj, si = map(int, input().split())          # 출발위치
    lst = []                                    # 편의점 위치 넣을 곳
    for _ in range(N):
        tj, ti = map(int, input().split())      # 편의점 위치
        lst.append((tj, ti))
    ej, ei = map(int, input().split())          # 도착위치

    result = bfs(sj, si, ej, ei)
    print(result)

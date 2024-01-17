# 로봇 청소기 문제

# 조건들을 간략하게 만들어서 , 설계 후 코드짜기


di = [-1,0,1,0]
dj = [0,1,0,-1]

def solve(ci,cj,dr):
    cnt = 0
    while 1:                # 청소기가 더이상 못움직일때 종료

        #[1] 현재위치 청소, 청소한곳 count
        arr[ci][cj] = 2
        cnt += 1

        # [2] 반시계 방향으로 순서대로 탐색해서 미청소 영역이 있는경우 이동/방향설정, 없으면 후진
        flag = 1
        while flag ==1:
            for nd in ((dr+3)%4,(dr+2)%4,(dr+1)%4,dr):  # 반시계 방향으로 회전
                ni,nj = ci+di[nd], cj+dj[nd]            # 이동한 위치 구하기
                if arr[ni][nj] == 0:                    # 청소안한 구역이라면
                    ci,cj,dr = ni,nj,nd                 # 거기로 이동
                    flag = 0                            # while 문 탈출 (위에 while 문으로 감)
                    break                               # for 문 탈출
            else:
                bi,bj = ci-di[dr], cj-dj[dr]            # for문을(4방향) 다돌았는데 조건에 맞는게 없다면 => 후진
                if arr[bi][bj] == 1:                    # 후진하는데 벽이라면
                    return cnt                          # 끝내고 cnt 출력
                else:
                    ci,cj = bi,bj
    return -1

N,M = map(int,input().split())
si,sj,dr = map(int,input().split())
arr = [list(map(int,input().split()))for _ in range(N)]

result = solve(si,sj,dr)
print(result)

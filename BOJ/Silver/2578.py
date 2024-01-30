# 빙고문제 (구현)
# (i,j) 좌표 테이블을 만드는게 핵심


# 5줄씩 나눠서 받을 수 가 있구나...(5줄은 arr배열에 5줄은 lst에)
arr = [list(map(int,input().split()))for _ in range(5)]

lst = []
for _ in range(5):
    lst += list(map(int,input().split()))

# pos_lst 이라는 (i,j) 좌표 테이블을 만들어줌
pos_lst = [0] * 26
for i in range(5):
    for j in range(5):
        pos_lst[arr[i][j]] = (i,j)

# 가로, 세로, 대각선, 대각선, v배열만들어줌
v = [[0] * 10 for _ in range(4)]

for n in lst:
    i,j = pos_lst[n]   # 사회자가 불러준 숫자 좌표를 i,j에 할당
    v[0][j] += 1       # v0~v3까지 맞는 위치에 +1씩 해줌 ( 총 5가 되면 빙고인셈 )
    v[1][i] += 1
    v[2][i+j] += 1
    v[3][i-j] += 1
    cnt = 0
    for i in v:
        cnt += i.count(5)   # v배열을 하나씩 돌면서 (5인 수)를 누적합산
    if cnt >=3:             # 빙고 3이면 승리
        break
print(sum(v[0]))            # 답 : 결국 하나의 v배열에 몇개가 찍혔는지 찾으면 (v배열 아무꺼나 상관x)
                            #      = 사회자가 몇번째 불렀을때 끝났는지 알 수 있음

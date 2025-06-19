# 접근방식
# 1. 체스보드를 배열로 입력받아서 완벽한 w_board, b_board 와 비교하여 최소의 값을 찾아낸다
# 2. 큰 체스판에서 8x8 크기의 체스판씩 규격을 맞춰서 비교하기 위해 ni,nj 사용


n, m = map(int, input().split())
chessboard = list(input() for _ in range(n))
w_board = [
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW'
]
b_board = [
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB'
]
def check(i, j):
    result_w = 0
    result_b = 0
    for di in range(8):
        for dj in range(8):
            ni, nj = di + i, dj + j
            if w_board[di][dj] != chessboard[ni][nj]:
                result_w += 1
            if b_board[di][dj] != chessboard[ni][nj]:
                result_b += 1
    return min(result_w,result_b)

result = 1000000
for i in range(n-7):
    for j in range(m-7):
        result = min(result, check(i,j))

print(result)





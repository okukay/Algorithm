# bfs를 이용해서 풀려했는데 안풀림..
# 그래서 다른 사람 풀이를 참고함
# "#" 과 "." 만 고려함 "?" 는 고려하지 않음
# board에 순서대로 [#짝수,#홀수,.짝수,.홀수]로 놓고 겹치지 않도록 하면 possible 아니면 impossible 


T = int(input())
for t in range(T):
    N, M = map(int, input().split())
    arr = [list(input()) for _ in range(N)]
    board = [0, 0, 0, 0]

    for col in range(N):
        for row in range(M):
            if arr[col][row] == '#':
                if (col + row) % 2 == 0:
                    board[0] += 1
                elif (col + row) % 2 == 1:
                    board[1] += 1
            elif arr[col][row] == '.':
                if (col + row) % 2 == 0:
                    board[2] += 1
                elif (col + row) % 2 == 1:
                    board[3] += 1
    print(board)
    if (board[0] and board[1]) or (board[2] and board[3]) or (board[0] and board[2]) or (board[1] and board[3]):
        answer = 'impossible'
    else:
        answer = 'possible'

    print(f"#{t + 1}", answer)

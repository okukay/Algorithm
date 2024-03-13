# 완전 탐색 문제
# BBABB 같은 회문 찾는방법 ==>   A == A[::-1]  면 회문
# 세로 검사할때 슬라이싱 주의!


for test_case in range(1,11):
    n = int(input())
    arr = [list(input())for _ in range(8)]
    cnt = 0

    #가로검사
    for i in range(8):
        for j in range(8-n+1):
            result = arr[i][j:j+n]
            if result == result[::-1]:
                cnt += 1

    # 세로 검사
    for i in range(8):
        for j in range(8-n+1):  # for j in range(5)
            result = ''
            for z in range(n):
                 result += arr[j+z][i]
            if result ==result[::-1]:
                cnt += 1

    print(f'#{test_case} {cnt}')

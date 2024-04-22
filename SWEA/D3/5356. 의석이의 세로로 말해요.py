# 세로로 출력 문자마다 길이가 달라서 공백인 부분을 try - except 문으로 처리


T = int(input())
for test_case in range(1, T + 1):

    arr = [input() for _ in range(5)]

    result = ''
    for j in range(15):
        for i in range(5):
            try:
                result += arr[i][j]
            except:
                result += ''
    print(f'#{test_case} {result}')

# 전부 리스트에 저장한 후 max() 해주려하니 ==> 런타임에러 발생

# max값을 최신화 시키는 방법으로 풀이!


for test_case in range(1,11) :
    T = int(input())

    array = [list(map(int,input().split()))for _ in range(100)]
    MAX = 0
    # 가로줄의 합
    for i in range(100) :
        sum = 0
        for j in range(100) :
            sum += array[i][j]
        if sum > MAX :
            MAX = sum

    # 세로줄의 합  
    for i in range(100) :
        sum = 0
        for j in range(100) :
            sum += array[j][i]
        if sum > MAX :
            MAX = sum

    # 대각선의 합
    sum1 = 0
    sum2 = 0
    for i in range(100) :
        sum1 += array[i][i]
        sum2 += array[i][99-i]
    if max(sum1, sum2) > MAX :
        MAX = max(sum1, sum2)

    print(f'#{test_case} {MAX}')

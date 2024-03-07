#전형적인 그냥 구현문제

T = int(input())
for test_case in range(1, T+1):
    result = []
    n = int(input())
    while 1:
        for i in (2,3,5,7,11):
            if n % i == 0:
                n  = n/i
                result.append(i)
                break
        if n < 2:
            break

    answer = ' '.join(str(result.count(j)) for j in (2, 3, 5, 7, 11))
    print(f"#{test_case} {answer}")

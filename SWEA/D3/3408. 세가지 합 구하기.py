# 수열공식

tc = int(input())
for test_case in range(1,tc+1):

    N = int(input())
    s1 = ((N + 1) * N) // 2    #정수 중에서 작은 순서대로 N개의 합
    s2 = N**2                  #홀수인 것들 중에서 작은 순서대로 N개의 합
    s3 = (N+1) * N             #짝수인 것들 중에서 작은 순서대로 N개의 합

    print(f"#{test_case} {s1} {s2} {s3}")

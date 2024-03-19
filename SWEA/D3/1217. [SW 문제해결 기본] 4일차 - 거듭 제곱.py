# 재귀함수 호출하는 문제 유형 

def power(N, M):
    if M == 0:
        return 1
    else:
        return N * power(N, M - 1)

for test_case in range(1,11) :
    T = int(input())
    N, M = map(int, input().split())

    result = power(N,M)
    print(f'#{test_case} {result}')

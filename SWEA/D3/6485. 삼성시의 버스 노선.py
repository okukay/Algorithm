# count 함수를 썼는데 런타임 에러가 발생함

# 그래서 그냥 cnt += 1 해가는 형식으로 최종적으로 카운트를 확인함


tc = int(input())
for test_case in range(1,tc+1):
    result = []
    bus = [0] * 5001
    N = int(input())
    for _ in range(N):
        A,B = map(int,input().split())
        for i in range(A,B+1):
            bus[i] += 1

    P = int(input())
    for i in range(P):
        c = int(input())
        result.append(bus[c])

    print("#" + str(test_case) ,end =' ')
    print(*result)

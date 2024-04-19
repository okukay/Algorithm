# 홀수 짝수로 판별해서 해결

tc = int(input())
for test_case in range(1,tc+1):

    n = list(input()) # ppzqq

    set_n = list(set(n))   # qzq

    result = []
    for i in set_n:
        if n.count(i) % 2 == 0:
            continue
        elif n.count(i) % 2 == 1:
            result.append(i)
    if result == []:
        print(f"#{test_case} Good")
    else:

        result.sort()
        result = ''.join(result)

        print(f"#{test_case} {result}")

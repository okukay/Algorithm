# 일반적으로 구현하는 문제라고 생각함!

tc = int(input())
for test_case in range(1,tc+1):
    n = input()
    arr = list(input().split())
    result = []
    b = len(arr)//2

    for i in range(b):
        if len(arr) % 2 == 0:
            result.append(arr[i])
            result.append(arr[i+b])
        if len(arr) % 2 == 1:
            result.append(arr[i])
            result.append(arr[i+b+1])
            if i == b - 1:
                result.append(arr[b])

    answer = ' '.join(result)
    print(f'#{test_case} {answer}')

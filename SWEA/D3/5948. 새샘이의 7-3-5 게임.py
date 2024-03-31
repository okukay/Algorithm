# 조합구해서 푸는 문제인데 # from itertools import combinations 모듈을 안쓰고 
# 구현해서 풀어봄..

def comb(arr,n):
    result = []
    if n == 0:
        return [[]]

    for i in range(len(arr)):
        elem = arr[i]
        for rest in comb(arr[i+1:],n-1):
            result.append([elem]+rest)
    return result

tc = int(input())
for test_case in range(1,tc+1):

    arr = list(map(int,input().split()))
    arr2 = (comb(arr,3))
    result2 =[]
    for i in arr2:
        result2.append(sum(i))

    result2.sort()
    a = set(result2)
    answer = list(a)[-5]

    print(f'#{test_case} {answer}')

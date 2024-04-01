# 소수구하기 (feat. 에라토스테네스의 체)
# 모든 경우의 수를 돌면서 소수를 판별하는 것이 아니기 떄문에 매우 효율적이다.
# 원리 : 작은수 순서대로 그 수의 배수를 지워나가는 방식, 최종적으로 남은수가 소수

import math

n = 1000000
# 처음엔 모든 수가 소수(True)인것으로 초기화
arr = [True for i in range(n+1)]

# 에라토스테네스의 체 알고리즘 수행
# 2부터 n의 제곱근까지의 모든 수를 확인
for i in range(2,int(math.sqrt(n))+1):
    if arr[i] ==True:
        # i를 제외한 i의 모든 배수 지우기
        j = 2
        while i * j <=n:
            arr[i*j] = False
            j += 1
# 모든 소수 출력
for i in range(2, n+1):
    if arr[i]:
        print(i, end =' ')

# 에라토스테네스의 체를 이용하여 999범위까지의 소수를 모두 구한후 뽑아서 사용하는것이 시간이 더 적게듬,// 
# tc마다 새로 소수를 구하는 것보다

# 3중 for문 사용( 3개의 합이기 떄문에) 
# for문 하나 마다 if문으로 이미 n(구하고싶은 값) 보다 작아야 다음 소수를 고를 수 있도록 설계 해서 시간을 줄임


import math
prime = []
n = 999
arr = [True for i in range(n+1)]

for i in range(2,int(math.sqrt(n))+1):
    if arr[i] == True:
        j = 2
        while i*j <= n:
            arr[i*j] = False
            j += 1

for i in range(2,n+1):
    if arr[i] == True:
        prime.append(i)

tc = int(input())
ans = []
for test_case in range(1,tc+1):
    result = 0
    n = int(input())
    for i in range(len(prime)):
        if prime[i] < n:
            for j in range(i,len(prime)):
                if prime[i] + prime[j] < n:
                    for z in range(j,len(prime)):
                            if prime[i]+prime[j]+prime[z] == n:
                                result += 1
    ans.append(result)

for i in range(len(ans)):
    print("#" + str(i+1), ans[i])

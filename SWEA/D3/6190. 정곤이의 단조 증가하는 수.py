# 문제를 꼼꼼히 봐야함
#  """Ai x Aj값이"""  단조 증가하는 수인 것들을 구하는 문제임

#2 단조인지 확인 하는 함수
def isdanjo(si):
    for i in range(1,len(si)):     # 1
        if si[i-1] > si[i]:
            return False
    int_si = int(si)
    return int_si

tc = int(input())
for test_case in range(1,tc+1):
    n = int(input())  # 4
    num = list(map(int, input().split()))  # 2 4 7 10
    danjo = []
  
    #1 모든 경우의수 돌기
    for i in range(n-1):
        for j in range(i+1,n):
            number = (num[i] * num[j])
            danjo.append(str(number))
          
    #3 단조값중 최댓값 최신화 시키기
    max = 0
    for si in danjo:
        result = isdanjo(si)
        if max < result:
            max = result
        if max == 0:
            max = -1

    print(f'#{test_case} {max}')

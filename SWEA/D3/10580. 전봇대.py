# 양끝점을 A와 B라고 정의하고
# (A보다 작고 B보다 큼) OR (A 보다 크고 B보다 작음)  ==> 이 조건 안에 들어오면 겹치는 부분이 발생한다는 규칙 찾음 

tc = int(input())
for test_case in range(1,tc+1):

    N = int(input())            # 3
    info = [[] for _ in range(N)]
    for i in range(N):
        info[i] = list(map(int, input().split()))

    count = 0
    for i in range(N):
        for j in range(i+1,N):
            l1,r1 = info[i]
            l2,r2 = info[j]
            if (l1>l2 and r1<r2) or (l1<l2 and r1>r2):
                count += 1
    print(f"#{test_case} {count}")

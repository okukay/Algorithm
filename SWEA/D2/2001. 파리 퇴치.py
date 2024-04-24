# 파리채 크기 만큼 전체영역을 돌면서 max값 갱신

tc = int(input())
for test_case in range(1,tc+1):
    N,M = map(int,input().split())      

    arr = [list(map(int,input().split())) for _ in range(N)]


    cnt = N-M+1      # 
    max = 0
    for i in range(cnt):
        for j in range(cnt):
            result = 0
            for si in range(i,i+M):
                for sj in range(j,j+M):
                    result += arr[si][sj]
            if result >= max:
                max = result
    print(f"#{test_case} {max}")

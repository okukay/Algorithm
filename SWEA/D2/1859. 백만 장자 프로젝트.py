# 거꾸로 돌려서 생각함

T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    arr = list(map(int,input().split()))[::-1]    # 거꾸로 정렬
   
    cnt = 0
    mx = 0
    for n in arr:
        if n >mx:
            mx = n
        else:
            cnt += (mx-n)
    print(f"#{test_case} {cnt}")

##### cnt 배열을 만들어서 , 마주보는 복도를 지나가는걸 카운팅

# 중복횟수 = v배열을 만들어서 사용할때마다 v[idx]에 +1씩 해서 얼마나 중복됬는지 알아내는 방식



tc = int(input())
for test_case in range(1,tc+1):
    N = int(input())
    cnt = [0] * 200
    for i in range(N):
        s,e = map(int,input().split())
        if s > e:
            s,e = e,s
        for j in range((s - 1) // 2, (e - 1) // 2 + 1):      # ex) 방1과 방2가 하나의 복도를 가지는데 => 이걸 -1씩해주고 나누기 2를 해주면,
                                                             # 방1도, 방2도, cnt배열 하나에 추가를 할 수 있게 된다. (하나의 복도로)
            cnt[j] += 1                                      # (1-1)//2 = 0, (2-1)//2 = 0 즉, 1과 2에 해당하는 값을 cnt배열 하나에 추가 할 수 있게 됨!
    print(f"#{test_case} {max(cnt)}")

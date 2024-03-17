tc = int(input())
for test_case in range(1,tc+1):
    N, M, K = map(int,input().split())
    cus = list(map(int,input().split()))
    cus.sort()


    ans = "Possible"
    cnt = 0
    for t in cus:
        cnt += 1
        # t 초에 기대할 수 있는 붕어빵 개수  (t //M) * K개
        if (t //M) * K < cnt:       # 손님 한명이라도 못주면 "Impossible"
            ans = "Impossible"
            break
    print(f'#{test_case} {ans}')
  
# 2초에 2개씩 만들어 낸다면
# 4초에는 4개의 붕어빵이 될것이고
# 이미 온사람에게 준것을 빼는게 아니기 때문에 , for문을 돌때마다 cnt(사람수)증가해서 계산
   #
   # 즉 2손님 2초에 1개 ,(2,4)일떄
   # 2초에 기대수량 1 < cnt(1)   // false
   # 4초에 기대수량 2 < cnt(2)   // false
   # 2초에 온사람에게 준걸 빼지 않았기 때문에, 4초에 기대수량이 2이고 , 2초 4초 온사람이 2명이라서 cnt(2)로 계산
   # 2손님에게 2개붕어빵 줄수 있기 때문에
   # 결과 : Possible

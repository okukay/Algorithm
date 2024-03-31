# 구현문제
# insert(위치, 넣을값) 
# for문으로 하나씩 넣어야 묶이지가 않음..

for test_case in range(1,11):

    one = int(input())
    two = list(map(int,input().split()))
    three = int(input())
    order = input().split()


    for i in range(len(order)):
        if order[i] == "I":
            index = int(order[i+1])         # 1
            count = int(order[i+2])         # 5
            num = order[i+3 : i+3 + count]    # 400905 139831 966064 336948 119288  넣을 숫자

            n = 0
            for i in num:                    # 400905 139831 966064 336948 119288 넣어야 하는 숫자 
                two.insert(index+n,i)        # 넣어야 하는 index가 하나 넣을때 마다 늘어나기 때문에 
                n += 1                       # 1씩 계속 올림
    result = ' '.join(map(str,two[:10]))

    print(f'#{test_case} {result}')

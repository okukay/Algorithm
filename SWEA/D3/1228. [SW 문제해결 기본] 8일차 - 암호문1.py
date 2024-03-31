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
            num = order[i+3 : i+3 + count]     

            n = 0
            for i in num:                    # 이부분이 헷갈렸음..(추가하는 부분)
                two.insert(index+n,i)
                n += 1
    result = ' '.join(map(str,two[:10]))

    print(f'#{test_case} {result}')

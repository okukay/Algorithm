# while  문안에 for문이 있을때 종료하기 위해 ==>  flag 활용 

for test_case in range(1,11):
    n = int(input())
    password = list(map(int,input().split()))
    n =0
    while True:
        flag = False
        for i in range(1,6):
            f_password = password.pop(0)
            f_password -= i
            if f_password <=0:
                f_password = 0
            password.append(f_password)

            if f_password <= 0:
                flag = True
                break

        if flag :
            break
    result = (' '.join(map(str, password)))         ## 리스트안에서 " "을 기준으로 꺼내주는 코드 (조건 : 문자열이여야함)

    print(f'#{test_case} {result}')

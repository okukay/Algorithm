# 여기서도 flag = True 사용함


for test_case in range(1,11):
    n = []
    num,arr = list(input().split())
    for i in arr:
        n.append(int(i))

    while True:
        flag = False
        for i in range(len(n)-1):    
            if n[i] == n[i+1]:        
                flag = True
                n.pop(i)          # pop()을 이렇게 사용한 이유 : 한번 pop하면 n배열이 줄어들어서 
                n.pop(i)          # pop(i+1) 하기 위해서 pop(i)를 함
                break

        if flag == False:
            break
        result = ''.join(map(str,n))
        result = int(result)

    print(f'#{test_case} {result}')

tc = int(input())
for i in range(tc):
    nums = set()
    n = int(input())   
    cnt = 0
    while len(nums) < 10: # nums에 10개가 들어오기 전까지 무한 반복
        cnt += 1
        tmp =str(n*cnt)    # 밑의 len()을 해주기위해서 문자열로 바꿔준다.
        
        for j in range(len(tmp)):   # ex) "123"을 하나씩 잘라서 저장하기
            nums.add(int(tmp[j]))   # set에는 append(x) add(o)


    print(f'#{i + 1} {tmp}')

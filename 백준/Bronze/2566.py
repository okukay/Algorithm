max_num=0
col=0   # 이걸 정의 하지않으면 런타임 에러 (NameError) 뜸
row=0   #  ""
for i in range(9):
    line = list(map(int,input().split()))
    if max(line) > max_num:
        max_num = max(line)  # 최대값으로 계속 최신화
        row = i # 행
        col = line.index(max_num) # (행의 최대값의 index) = 열
print(max_num)
print(col+1,row+1)  # +1 하는이유 : 1행 1열 부터 시작하기 때문에

# 접근 방법
# 4방향 모서리 값을 찾음 그 후
# 4변의 길이가 같은지 확인 and 모서로 행렬 돌면서 모두 "#" 인지 확인
# 하나라도 만족 못할시 NO출력


tc = int(input())
for test_case in range(1,tc+1):

    n = int(input())

    arr = [list(input()) for _ in range(n)]

    result = []
    x_list = []
    y_list = []
    for i in range(n):
        for j in range(n):
            if arr[i][j] == "#":
                result.append([i,j])

    for i in range(len(result)):    # 0,1,2,3,4,5,6,7,8
        x_list.append(result[i][0])
        y_list.append(result[i][1])

    x_max = max(x_list)
    x_min = min(x_list)
    y_max = max(y_list)
    y_min = min(y_list)

    first_L = [x_min,y_min]
    first_R = [x_min,y_max]
    last_L = [x_max,y_min]
    last_R = [x_max,y_max]

    # 네 변의 길이가 똑같아야 함
    result = "yes"
    if (first_R[1] - first_L[1]) == (last_R[1]-last_L[1]) == (last_L[0] -first_L[0]) == (last_R[0] - first_R[0]):

        flag = True
        for i in range(first_L[0],last_L[0]+1):       
            for j in range(first_L[1],first_R[1]+1):    
                if arr[i][j] != "#":
                    flag = False
                    result = "no"
                    break
            if flag == False:
                break
    else:
        result = "no"

    print(f"#{test_case} {result}")

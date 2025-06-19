# 픽셀처럼 겹치는 부분을 생각하지않고, 100*100 도화지를 0으로 초기화 시켜놓고 , 색종이 부분을 1로 변경하여 
# 최종적으로 1인 부분만 구하는 방식

n = int(input())
array = [[0 for i in range(100)] for j in range(100)]  # 2차원 배열 만드는 방법 
                                                       # array1 = [[0]* 100 for i in range(100)]
for _ in range(n):
    x,y = map(int,input().split())

    for i in range(x, x+10):
        for j in range(y, y+10):
            array[i][j] = 1       # 색종이부분 1로 설정
    
result = 0
for i in  array:
    result += i.count(1)

print(result)

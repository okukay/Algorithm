A,B =[],[]
N,M = map(int,input().split())

for _ in range(N):                       # 첫번째 배열 만들기
    row = list(map(int,input().split()))  
    A.append(row)

for _ in range(N):                        # 두번째 배열 만들기
    row = list(map(int,input().split()))  
    B.append(row)

for row in range(N):                     # 행
    for col in range(M):                 # 열 2중 for 문으로 표현
        print(A[row][col] + B[row][col], end= " ")
    print()

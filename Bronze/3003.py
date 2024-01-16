A = [1,1,2,2,2,8]
N = list(map(int,input().split())) 
for i in range(6):
    print(A[i]-N[i],end = " ")  # (올바른 세트) - (내 세트) = 몇개가 필요한지 


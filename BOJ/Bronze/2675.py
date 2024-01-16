T = int(input())

for i in range(T):
    S, R = input().split()   # 둘다 str로 받아서 
    for i in R:
        print(int(S) * i, end= "")  # 개수는 int씌우기 
    print()

score = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
tc = int(input())
n,m = map(int,input().split())
total =[]
for _ in range(n):
    a,b,c = map(int,input().split())
    total.append(a*0.35 + b*0.45 + c*0.20)

    k_score = total[m-1]
    total.sort()
    print(total)

score = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
t = int(input())
for tc in range(1,1+t):
    n,m = map(int,input().split())
    total =[]
    for _ in range(n):
        a,b,c = map(int,input().split())
        total.append(a*0.35 + b*0.45 + c*0.20)

    k_score = total[m-1]
    total.sort(reverse=True)

    value = n // 10
    result = total.index(k_score) // value  # 여기부분만 기억하기 !  찾고자하는 인덱스 // (전체수 //10)

    print("#%d %s" % (tc, score[result]))

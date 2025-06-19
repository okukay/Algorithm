N = int(input())
score = list(map(int,input().split())) # input을 그냥 다적어서 list로 묶어서 만듬
M = max(score)

for i in range(N):
    score[i] = score[i]/M*100

print(sum(score)/N)

N = int(input())
X = []
Y = []
for i in range(N):
    x,y = map(int,input().split())
    X.append(x)
    Y.append(y)

width =(max(X)-min(X))        # max - min = 거리
length=(max(Y)-min(Y))

print(width * length)

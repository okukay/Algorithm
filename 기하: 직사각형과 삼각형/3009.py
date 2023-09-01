X = []
Y = []

for i in range(3):
    x, y = map(int, input().split())
    X.append(x)
    Y.append(y)

for i in range(3):                # X축이 두개씩 똑같아야함,  
    if X.count(X[i]) == 1:        # 즉 count해서 1개인것을 찾아내고 , 그게 네번째 찾아야할 X축이다
        x = X[i]
    if Y.count(Y[i]) == 1:
        y = Y[i]

print(x, y)

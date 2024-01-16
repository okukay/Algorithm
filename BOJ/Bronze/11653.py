N = int(input())
i = 2
while N != 1:
    if N % i == 0:
        N = N // i
        print(i)
    elif N % i !=0:
        i = i+1

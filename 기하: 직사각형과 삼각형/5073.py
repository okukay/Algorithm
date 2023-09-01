while True:
    a,b,c = map(int,input().split())

    if a > 0 and b >0 and c >0:                # 장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
        if max(a,b,c) >= (a+b+c)-max(a,b,c):   # 가장긴 변의 길이 > (세변의 길이 합) - (가장긴변 길이)
            print("Invalid")                                                       ㄴ> 나머지 두변의 길이 
        elif a == b == c:
            print("Equilateral")   
        elif (a == b or b == c or a ==c):
            print("Isosceles")
        elif a != b != c:
            print("Scalene")
    elif a ==0 and b ==0 and c ==0:
        break    

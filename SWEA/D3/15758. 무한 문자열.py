## 최소공배수 구하기 
## 최소공배수 만들만큼 곱한후 비교 !

tc = int(input())
for test_case in range(1,tc+1):

    a,b = input().split()
    s = len(a)
    t = len(b)
    # 최소공배수 구하기
    for i in range(max(s,t),(s*t)+1):
        if i % s == 0 and i % t == 0:
            lcm = i
            break

    s_1 = (a * (lcm // s))
    t_1 = (b * (lcm // t))

    result = ""
    if s_1 == t_1:
        result = "yes"
    else:
        result = "no"
    print(f"#{test_case} {result}")

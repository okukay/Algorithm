# 구현문제

for test_case in range(1,11):
    n = int(input())
    arr= input()

    v = [0] * 4
    for i in arr:
        if i == "}":
            v[0] += 1
        elif i == "{":
            v[0] -= 1
        elif i == "[":
            v[1] += 1
        elif i == "]":
            v[1] -= 1
        elif i == "(":
            v[2] += 1
        elif i == ")":
            v[2] -= 1
        elif i == "<":
            v[3] += 1
        elif i == ">":
            v[3] -= 1

    

    result = 1
    for i in v:
        if i != 0:
            result = 0
            print(f"#{test_case} {result}")
            break
    else:
        print(f"#{test_case} {result}")

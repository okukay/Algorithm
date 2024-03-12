# 구현 문제

tc = int(input())
for test_case in range(1, tc+1):
    
    # 목표값
    n = []
    i = input()
    for char in i:
        n.append(int(char))

    # 초기값
    m = [0] *len(n)

    count = 0
    for i in range(len(n)):
        if m[i] == n[i]:
            continue
        elif m[i] != n[i]:
            count += 1
            for j in range(i, len(n)):
                if n[i] == 1:
                    m[j] = 1
                elif n[i] == 0:
                    m[j] = 0
        if n == m:
            print(f'#{test_case} {count}')
            break

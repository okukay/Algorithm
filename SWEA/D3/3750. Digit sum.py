### 구현문제
### 시간초과 해결법 : 결과값을 마지막에 한번에 출력 (tc가 100000개 이기 때문에)

tc = int(input())
ans = []
for test_case in range(1,tc+1):

    n = input()
    result = 0
    while True:
        for i in n:
            result += int(i)
        n = str(result)

        if result < 10 :     # 한자리면 break
            ans.append(result)
            break
        elif result > 9 :
            result = 0

for idx,val in enumerate(ans):
    print(f"#{idx+1} {val}")

# 문제 이해가 어려움...
# 자연수 N에 1,2,3 ... 값을 곱해서 재배열 했을때 원본과 같이 재배열 할 수 있는가를 물어보는 문제
# 즉 곱했을때 원소가 똑같냐 이말임

# 그래서 원본,곱한값 둘다 정렬시켜서 같은지 비교함



tc = int(input())
for test_case in range(1,tc+1):
    num = input()
    num_list = list(num)
    new = num
    i = 2
    result = "impossible"
    while True:
        new = list(str(int(num) * i))
        i += 1

        # 둘다 sort 정렬
        sort_num = sorted(num_list)
        sort_new = sorted(new)

        if len(sort_num) != len(sort_new):
            break

        # 비교
        if sort_num == sort_new:
            result = "possible"
            break
    print(f'#{test_case} {result}')

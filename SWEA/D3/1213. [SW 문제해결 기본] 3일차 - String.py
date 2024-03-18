# count 함수 사용

for test_case in range(10):
    tc = int(input())
    n = input()
    sen = input()

    sen_count = sen.count(n)

    print(f'#{tc} {sen_count}')

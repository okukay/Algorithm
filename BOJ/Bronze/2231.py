# 접근방법
# 1. 입력 N을 "a = list(map(int, str(i)))" 를 통해서 개별적인 리스트로 만들어줌
# 2. N 과 합 + i 가 같으면 출력
# 3. 최소 값이기 때문에 제일 처음나오는 수가 최소값



N = int(input())
x = 0
for i in range(N):
    a = list(map(int, str(i)))
    if N == sum(a) + i:
        x = i
        break;
print(x)

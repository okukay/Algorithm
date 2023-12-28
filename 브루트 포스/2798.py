from itertools import combinations  #  combinations 라이브러리 사용

n, m = map(int, input().split())
array = list(map(int, input().split()))
result = []

for i in combinations(array, 3):        # combinations(array, 3) 3개를 뽑는 모든 조합을 알려준다 (순서 고려 X = > AB 와 BA를 같은걸로 본)
    if sum(i) > m:
        continue
    else:
        result.append(sum(i))
print(max(result))


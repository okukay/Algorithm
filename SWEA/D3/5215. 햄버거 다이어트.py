# combinations(조합) 이용한 완전탐색

# kcal 가 L을 넘지않는 조합에서 score 가 최대인 값으로 최신화 하는 방식

from itertools import combinations

t = int(input())

for tc in range(1, t + 1) :
    n, l = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(n)]
 
    max_score = 0
    for i in range(1, n + 1) :
        for value in combinations(data, i) :

            kcal = 0
            score = 0
            for v in range(len(value)) :
                kcal += value[v][1]
                score += value[v][0]
            if kcal > l :
                continue
            if max_score < score :
                max_score = score

    print(f'#{tc} {max_score}')
  

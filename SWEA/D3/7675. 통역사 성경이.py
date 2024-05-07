#####   rstrip("?"), isupper(), islower(), isalpha() 에 대해 새로 암.. 


tc = int(input())
for test_case in range(1,tc+1):

    n = int(input())
    sentence = ''
    while True:
        sentence += input()  # 하나의 문장으로 통합
        stopPoint = sentence.count('.') + sentence.count('?') + sentence.count('!')  # 구두점 갯수
        if stopPoint == n:  # 문장갯수
            break

    sentence = sentence.split()
    cnt = 0
    answer = []

    for i in range(len(sentence)):
        # .!? 가 오른쪽에 있으면 쭉 밀어버림
        word = sentence[i].rstrip(".!?")

        # 조건1 전부 알파벳인가
        if word.isalpha():
            # 조건2  대문자이고, 나머지가 소문자
            if word[0].isupper() and word[1:].islower():
                cnt += 1
            # 조건2  한자리이고 그게 대문자인가
            if len(word) == 1 and word[0].isupper():
                cnt += 1
        # .?! 나오면 문장의 끝이기 때문에 결과 저장
        if sentence[i][-1] in [".","?","!"]:
            answer.append(cnt)
            cnt = 0

    result = " ".join(map(str,answer))
    print(f"#{test_case} {result}")

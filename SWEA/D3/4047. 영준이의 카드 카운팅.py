#  for i in range(0,s_len,3): 이용해서 3개 단위로 잘라서 저장
# len(원본) != len(중복제거 리스트) 다르다면 중복이 존재했다는 것! "ERROR"
# 아니라면 count 이용

tc = int(input())
for test_case in range(1,tc+1):
    s_list = []
    card = ["S","D","H","C"]
    s = input()
    s_len = len(s)

    for i in range(0,s_len,3):     
       s_list.append(s[i:i+3])
       s_set = set(s_list)

    if len(s_list) != len(s_set):
        print(f'#{test_case} ERROR')

    elif len(s_list) == len(s_set):
        result =[]
        for j in card:
            card_count = s.count(j)

            result.append(13 - card_count)


        result = ' '.join(map(str,result))
        print(f'#{test_case} {result}')

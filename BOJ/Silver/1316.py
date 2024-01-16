# 그룹 단어를 찾기 위해 알파벳을 다음 알파벳과 비교하고
# 다를 경우 new_word로 설정한후 
# 기존알파벳이 new_word 에 동일한 알파벳이 있는지를 확인해나가는 방식 

n = int(input())

group_word = 0 
for a in range(n):
    word = input()
    error = 0 
    for i in range(len(word)-1):   # ex) happy = 5-1 =4 (0~4)
        if word[i] != word[i+1]:   # 처음알파벳 != 다음알파벳 다를경우
            new_word = word[i+1:]  #  다음알파벳부터 끝까지를 new_word로 저장
            if word[i] in new_word: # 기존 알파벳이 new_word에 포함되있을경우 (즉, 똑같은 알파벳이 뒤에또 나올경우(그룹단어가 안될))
                error = error + 1 
    if error == 0:
        group_word = group_word + 1

print(group_word)


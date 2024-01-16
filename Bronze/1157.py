word = input().upper()  # 대소문자 구분없애기 
word_list = list(set(word)) # set이용해서 중복없애기
cnt = [] 

for i in word_list: 
    count = word.count(i) # 문자가 몇개있는지 개수 저장
    cnt.append(count) # cnt 집합에 개수 추가  #ex) [4 4 1 1]

if cnt.count(max(cnt)) >=2:   # max(cnt) 가 두개 이상이면
    print("?")
else:
    print(word_list[cnt.index(max(cnt))])  

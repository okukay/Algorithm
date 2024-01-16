s = list(input())
c = "abcdefghijklmnopqrstuvwxyz"

for i in c:
    if i in s:
        print(s.index(i), end= " ")
    else:
        print("-1", end =" ") 

# or

# S = input()

# for x in 'abcdefghijklmnopqrstuvwxyz':
#     print(S.find(x), end = ' ')   # find 함수사용 (찾는 문자열의 순서를 알아서 출력해, 없을 경우 -1을 출력해줌)

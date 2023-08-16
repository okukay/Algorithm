croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()

for i in croatia:
    word = word.replace(i, "*")   # croatia 리스트를 넣으면서 동일하면 "*" 로 변경  
word                              # 왜냐 : 크로아티아 문자가 "dz=" 두개,세개씩 되어있어서 개수 세기 편하게 "*" 하나로 변경
print(len(word))

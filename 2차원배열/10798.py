word = []
length = []
for i in range(5):
    n = input()
    word.append(n)
    length.append(len(n))


result =''                    # 빈공간으로 설정
for i in range(max(length)):  #  열을 셀때 사용
    for j in range(5):        #  행을 셀때 사용
        if i < length[j]:     
            result = result + word[j][i]
print(result)

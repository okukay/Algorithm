numbers = []
for i in range(9):  # 0~8 까지
    a = int(input())
    numbers.append(a)  # number 리스트에 추가 

print(max(numbers))
print(numbers.index(max(numbers))+1)

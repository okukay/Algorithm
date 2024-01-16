arr = []
for i in range(10):
    a = int(input())
    if a%42 not in arr:  
        arr.append(a % 42)
print(len(arr))


# or

arr = []
for i in range(10):  # 
    n = int(input())
    arr.append(n % 42)
arr = set(arr)   #  set으로 중복제거 , 순서가 뒤죽박죽됨
print(len(arr))

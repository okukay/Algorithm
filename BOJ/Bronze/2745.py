num="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
n, b = input().split()  # (zzzzz 36)
result = 0
new_n = n[::-1]                   # (1234 10) 일때 10^0 을 맨뒷자리(4)에 곱해줘야 하기 때문에 역순으로 바꿈
for i in range(len(new_n)):
    result = result + (num.find(new_n[i])) * (int(b) ** i )  # find함수사용 위치 찾아서 index알려줌
print(result) 

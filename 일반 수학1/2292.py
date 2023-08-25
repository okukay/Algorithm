N=int(input())
beehouse = 1
count = 1                   # 지나는 개수
while N > beehouse :        # input이 구한 벌집보다 작으면 그앞 count
    beehouse += 6 * count   # 6의 배수만큼 더해서 벌집 개수를 구하고
    count+= 1
print(count)

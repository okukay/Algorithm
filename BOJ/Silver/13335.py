### 구현(시뮬레이션)
# 스택이용


n, w, l = map(int, input().split())
trucks = list(map(int, input().split()))

bridge = [0] * w  # w만큼 다리 길이 선언
weight, time = 0, 0  # 현재 다리위의 무게, 시간 선언

while True:
    out = bridge.pop(0)        
    weight -= out

    if trucks:
        if weight + trucks[0] <= l:      #  다리무게 + 들어올 트럭 >= L
            bridge.append(trucks[0])     #  다리에 트럭 한대 추가
            weight += trucks[0]          #  들어온 트럭무게만큼 무게 추가
            trucks.pop(0)                #  들어왔으니까 트럭 리스트에서 삭제

        else:                            # 다리무게 + 들어올 트럭 > L
            bridge.append(0)             # 못들어오기 때문에 0을 넣음!!!! (여기가 포인트 조건이 안맞아서 못들어오면 0을 넣어서 진행) 
    time += 1

    if bridge == []:                     # 다리에서 다 지나가면 break
        break
print(time)

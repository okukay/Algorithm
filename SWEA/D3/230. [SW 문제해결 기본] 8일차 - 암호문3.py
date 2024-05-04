# 구현문제인데 기존 내 코드는 n4에서 I,D,A 의 인덱스를 찾는데 시간이 많이 들었음
# 그래서 for문을 돌릴때 len(n4)를 사용해서 인덱스 번호로 for문을 돌리고 n4[i]로 I,D,A 가 맞는지 확인하는 방식 사용
# 이러면 for문 한번만 돌리면 해결 가능 !

for test_case in range(1,11):
    n1 = int(input())
    arr = list(map(int,input().split()))
    n3 = int(input())
    n4 = list(input().split())

       

    for idx in range(len(n4)) :
        if n4[idx] == "I":
            x = int(n4[idx + 1])     # 2 값
            y = int(n4[idx + 2])     # 3 값

            for j in range(y):  # 3번 반복 0 1 2
                arr.insert(x+j ,int(n4[idx+3+j]))

        elif n4[idx] == "D":
            x = int(n4[idx + 1])       # 8
            y = int(n4[idx + 2])       # 3
            del arr[x:x+y]      # 8부터 11까지 삭제

        elif n4[idx] == "A":
            x = int(n4[idx + 1])        # 2
            for j in range(x):
                arr.append(int(n4[idx+2+j]))

    ans = " ".join(map(str,arr[:10]))
    print(f"#{test_case} {ans}")

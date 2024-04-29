# 100 부터 줄여가면서 leng(회문길이)를 찾기 떄문에 True가 나오면, 그게 젤 최대값이 되는 방식

# 전치 행렬 => list(zip(*arr)) /// 1.언팩  2.zip씌우기  3.리스트로 묶기

def is_pal(arr, leng):
    for lst in arr:
        for i in range(n-leng+1):                  # range(전체길이-찾고싶은회문길이+1) => 시작할 수 있는 시작점 알 수 있음
            if lst[i:i+leng] ==lst[i:i+leng][::-1]:
                return True
    return False
  
for test_case in range(1,11):
    num = int(input())
    n = 100
    arr = [list(input()) for _ in range(n)]
    # print(arr)
    arr2 = [''.join(x) for x in zip(*arr)]    # 리스트 전치 하는 방법

    for leng in range(n,1,-1):
        if is_pal(arr,leng) or is_pal(arr2,leng):
            break

    print(f"#{num} {leng}")

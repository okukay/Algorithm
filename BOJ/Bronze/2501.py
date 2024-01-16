N,K = map(int,input().split())

arr = []

for i in range(1, N + 1):   #
    if (N % i == 0) :       #
            arr.append(i)   # 약수 구해서 리스트저장
if K >len(arr):             # K번째작은수가 없을경우 = k가 arr배열보다 클경우 
    print("0")
else:
    print(arr[K-1])

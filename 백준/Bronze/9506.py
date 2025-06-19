while 1:
    N = int(input())
    if N == -1:
       break
    arr = []
    for i in range(1, N):
        if (N % i == 0) :
                arr.append(i)

    if sum(arr) == N:
        print(N,"=",end=" ")           # end = " "는 줄바꿈을 안한다는 의미  # print(str, int )를 같이 쓰려면 "," 를사용 밑에 설명 추가첨
        print(*arr,sep=" + ")          # (*arr) = unpacking 
    else:                              # seq 구분자이며 , 문자열 사이사이에 구분자를 넣을 수 있다   
        print(N, "is NOT perfect.")   


      
# A = 1 
# B = "문자"
# print(type(A))     # int형
# print(type(B))     # str형
# print(str(A) + B)  # 1번) int를 str로 묶에서 str + str로 만들거나
# print(A , B)       # 2번) str과 int 사이에 "+" 가 아닌 "," 사용하기

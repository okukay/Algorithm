# MenOfPassion(A[], n) {
#     sum <- 0;
#     for i <- 1 to n
#         for j <- 1 to n
#             sum <- sum + A[i] × A[j]; # 코드1
#     return sum;
# }

# 이중 for문의 시간복잡도
# 수행 횟수는 n의 제곱 , 수행 시간은 2. (상수 시간이 소요되면 0 , n에 비례하면 1 , 2n에 비례하면 2)

n = int(input())

print(n**2)
print(2)



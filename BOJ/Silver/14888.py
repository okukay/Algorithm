# 백트래킹 
# swea에 숫자만들기랑 같은문제임

def dfs(n,num,add,sub,mul,div):
    global mx,mn
  # 종료조건
    if n == N:
        mx = max(num,mx)
        mn = min(num,mn)
        return mx
      
  # 연산자가 있다면 dfs실행
  # 연산자 마다 현재 num에 연산해주고, -1 해
    if add:
        dfs(n + 1, num + arr[n], add - 1, sub, mul, div)
    if sub:
        dfs(n + 1, num - arr[n], add, sub - 1, mul, div)
    if mul:
        dfs(n + 1, num * arr[n], add, sub, mul - 1, div)
    if div:
        dfs(n + 1, int(num / arr[n]), add, sub, mul, div - 1)

N = int(input())
arr = list(map(int,input().split()))
g = list(map(int,input().split()))
mn = int(1e9)
mx = int(-1e9)

dfs(1,arr[0],g[0],g[1],g[2],g[3])
print(mx)
print(mn)

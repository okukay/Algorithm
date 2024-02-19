

from collections import deque
def solution(maps):
    

    def bfs(si, sj):
        queue = deque()
        queue.append((si, sj))

        # queue가 빌 때까지 반복
        while queue:
            ci, cj = queue.popleft()

            # 상하좌우 칸 확인하기
            for di,dj in ((-1,0),(1,0),(0,-1),(0,1)):
                ni,nj = ci+di,cj+dj
                if 0<=ni<len(maps) and 0<=nj<len(maps[0]) and maps[ni][nj] == 1:
                    maps[ni][nj] = maps[ci][cj] + 1
                    queue.append((ni, nj))    # 재귀

        return maps[len(maps)-1][len(maps[0])-1] #이게 answer 에 들어오고 
    

    answer = bfs(0, 0)
    if answer == 1:
        return -1
    else:
        return answer
  

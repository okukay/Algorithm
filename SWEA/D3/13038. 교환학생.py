# 완전탐색 문제인것 같다
# 시작하는 요일에 따른 최소 등교일수를 찾는 문제(일정 수업듣기 위해)


tc = int(input())
for test_case in range(1, tc+1):
    n = int(input())
    week = list(map(int,input().split()))
    answer = []
    for i ,val in enumerate(week):
        if val == 1:                # 최소 등교일 찾기 위해, 수업이 있는날을 개강일로 지정하고 탐색
            index = i      
            temp = n                # 목표하는 수업 일수
            result = 0
          
            while temp > 0:          # 첫 개강날짜를 잡으면, 그뒤로 목표일수를 다채울때까지 무한 루프
                if week[index] == 1:
                    temp -= 1           # 수업을 들었다면 -1씩 해서 목표(temp)가 0이 되면 break
                index = (index+1)%7     # 첫 개강날짜(index)를 시작으로 7일이 계속 돌아감
                result += 1             # 학교 등교한 일수
            answer.append(result)
          
    sol = min(answer)
    print(f'#{test_case} {sol}')

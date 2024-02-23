# 순열을 사용하면 런타임에러 발생함

def solution(numbers):
    answer = ''
    number = list(map(str,numbers))

    number.sort(key = lambda x:x*3,reverse =True)   # x에 3을 곱한걸 기준으로 sort해주는 문법!!!! 그리고 뒤집기
    
    answer = str(int("".join(number)))              # 답을 문자열로 제출하라고 했는데 int를 해주고 , str을 해주는 이유는 
    return answer                                   #  = [0,0,0,0] 이 들어가면 현재 0000으로 나오므로 int()를 통해 0으로 바꿔야한다

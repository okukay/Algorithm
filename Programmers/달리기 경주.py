# 딕셔너리 사용, 그냥했을경우 시간초과뜸

def solution(players, callings):
    dict = {player: idx for idx, player in enumerate(players)}
   

    for i in callings:
        index = dict[i]     # 호명된 애 의 등수
        dict[i] -= 1        #  하나 앞으 등수로
        dict[players[index-1]] += 1 # 하나 뒤의 등수로  
        players[index-1], players[index] = players[index], players[index-1] # 여기서는 dict이 아니고 players 옮김
        
    return players

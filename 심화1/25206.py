rating = {"A+": 4.5, "A0": 4.0, "B+": 3.5, "B0": 3.0, "C+": 2.5, "C0": 2.0, "D+": 1.5, "D0": 1.0, "F": 0.0}
total = 0  # (학점 * 평점)
score_total = 0  # 총 들은 학점
 
for _ in range(20):
    subject, score, grade = input().split() 
    if grade == "P":   # p 학점일 경우 continue 
        continue

    total += float(score) * rating[grade]   # rating 의 key 값으로 value을 가져옴 ( "A+" 로 4.5 가져옴)
    score_total += float(score)
print('%.6f' %(total / score_total))
    
    

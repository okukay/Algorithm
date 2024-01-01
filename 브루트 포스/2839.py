# 접근 방식
# 1. 3kg과 5kg 봉지가 있는데 5kg으로 담는게 제일 최소의 봉지개수가 될것이다.
# 2. 5kg 으로 나눠서 떨어지면 그게 최소의 봉지수.
# 3. 안떨어질 경우에 3kg봉지로 하나 담고 또 5kg으로 나눠서 떨어지는지 확인.
# 4. sugar가 음수가 될경우 3kg , 5kg으로 나눌수가 없는 수.

sugar = int(input())
bag = 0

while True:
    if sugar % 5 == 0:
        bag += (sugar // 5)
        print(bag)
        break

    elif sugar % 5 != 0:
        sugar = sugar - 3
        bag += 1

    if sugar < 0:
        print("-1")
        break

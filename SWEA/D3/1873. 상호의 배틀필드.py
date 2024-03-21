# 구현문제.. 풀긴 풀었는데.. 이렇게 길게 구현하는게 맞는건지..

tc = int(input())

for test_case in range(1,tc+1):
    H, W =map(int,input().split())
    arr = [list(input()) for _ in range(H)]
    num = int(input())
    go = input()
    recent = ""

    # '^', 'v', '<', '>'의 index 구하기
    for i, row in enumerate(arr):
        for j, col in enumerate(row):
            if col in ['^', 'v', '<', '>']:
                si = i
                sj = j
                if arr[si][sj] == '^':
                    recent = "U"
                if arr[si][sj] == 'v':
                    recent = "D"
                if arr[si][sj] == '<':
                    recent = "L"
                if arr[si][sj] == '>':
                    recent = "R"

    for i in go:        # SURSSSSUSLSRSSSURRDSRDS 반복

        if i == "U":
            recent = "U"
            arr[si][sj] = "^"
            if 0 <= si-1 < H and arr[si-1][sj] == ".":
                arr[si][sj] = "."
                si = si-1
                sj = sj
                arr[si][sj] = "^"

        if i == "D":
            recent = "D"
            arr[si][sj] = "v"
            if 0 <= si+1 < H and arr[si+1][sj] == ".":
                arr[si][sj] = "."
                si = si+1
                sj = sj
                arr[si][sj] = "v"


        if i == "L":
            recent = "L"
            arr[si][sj] = "<"
            if 0 <= sj-1 < W and arr[si][sj-1] == ".":
                arr[si][sj] = "."
                si = si
                sj = sj-1
                arr[si][sj] = "<"

        if i == "R":
            recent = "R"
            arr[si][sj] = ">"
            if 0 <= sj+1 < W and arr[si][sj+1] == ".":
                arr[si][sj] = "."
                si = si
                sj = sj+1
                arr[si][sj] = ">"

        if i == "S":
            if recent == "U":
                for j in range(1,si+1):  # range(1,2) 1
                    if arr[si-j][sj] == "*":  # 벽만나면
                        arr[si-j][sj] = "."  # 땅으로 바꿔줌
                        break
                    if arr[si-j][sj] == "#":  # 강철벽 만나면 그냥 끝
                        break
                    if arr[si-j][sj] == "-":  # 강 만나면 그 뒤로 지나가게 continue
                        continue
                    if arr[si - j][sj] == ".":  # 땅 만나면 그 뒤로 지나가게 continue
                        continue


            if recent == "D":
                for i in range(1,H-si):  # (1,3) 1, 2
                    if arr[si+i][sj] == "*":  # 벽만나면
                        arr[si+i][sj] = "."  # 땅으로 바꿔줌
                        break
                    if arr[si+i][sj] == "#":  # 강철벽 만나면 그냥 끝
                        break
                    if arr[si+i][sj] == "-":  # 강 만나면 그 뒤로 지나가게 continue
                        continue
                    if arr[si+i][sj] == ".":  # 땅 만나면 그 뒤로 지나가게 continue
                        continue

            if recent == "L":
                for i in range(1,sj+1):  #
                    if arr[si][sj-i] == "*":  # 벽만나면
                        arr[si][sj-i] = "."  # 땅으로 바꿔줌
                        break
                    if arr[si][sj-i] == "#":  # 강철벽 만나면 그냥 끝
                        break
                    if arr[si][sj-i] == "-":  # 강 만나면 그 뒤로 지나가게 continue
                        continue
                    if arr[si][sj-i] == ".":  # 땅 만나면 그 뒤로 지나가게 continue
                        continue

            if recent == "R":
                for i in range(1,W-sj):           # range(1,6) 1,2,3,4,5  7-1
                    if arr[si][sj+i] == "*":      # 벽만나면
                        arr[si][sj+i] = "."       # 땅으로 바꿔줌
                        break
                    if arr[si][sj+i] == "#":      # 강철벽 만나면 그냥 끝
                        break
                    if arr[si][sj+i] == "-":      # 강 만나면 그 뒤로 지나가게 continue
                        continue
                    if arr[si][sj+i] == ".":      # 땅 만나면 그 뒤로 지나가게 continue
                        continue
    result = ""
    for row in arr:
        result += ''.join(row)+ '\n'

    print(f'#{test_case} {result}', end='')

while True:
    try:
        print(input())
    except EOFError:    # ctrl + d 를 하면 종료됨 EOF(end of file)
        break

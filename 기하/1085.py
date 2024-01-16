x,y,w,h = map(int,input().split())

print(min(x, w-x, y, h-y))   # 4가지 경우중 가장작은수 

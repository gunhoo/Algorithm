T = int(input())
for test_case in range(1, T+1):
    n = int(input())
    arr = [[0]*n for _ in range(n)]
    dy = [0,1,0,-1]
    dx = [1,0,-1,0]
    y, x = 0,0
    idx = 0

    for i in range(1, n*n+1):
        arr[y][x] = i
        y += dy[idx]
        x += dx[idx]

        if x < 0 or y < 0 or x>=n or y>=n or arr[y][x]!=0:
            y -= dy[idx]
            x -= dx[idx]
            idx = (idx+1)%4
            arr[y][x] = i
            y += dy[idx]
            x += dx[idx]

    print("#{}".format(test_case))
    for j in arr:
        print(*j)

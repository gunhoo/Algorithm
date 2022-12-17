import sys
input = sys.stdin.readline

def dfs(x, y):
    global idx
    visited[x] = 1

    if x == y:
        print(idx)
        exit(0)
    for i in range(1, n+1):
        if arr[x][i] != 0 and visited[i] == 0:
            idx += 1
            dfs(i, y)
    idx -= 1

n = int(input())
arr = [[0]*(n+1) for _ in range(n+1)]
visited = [0]*(n+1)
a, b = map(int, input().split())
m = int(input())
idx = 0

for _ in range(m):
    x, y = map(int, input().split())
    arr[x][y], arr[y][x] = 1, 1

dfs(a, b)
print(-1)
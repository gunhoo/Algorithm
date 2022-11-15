import sys
input = sys.stdin.readline

dx = [0,0,1,-1]
dy = [1,-1,0,0]
count, result = 0, 0
ans = []
def dfs(x, y):
    if x < 0 or x >= n or y >= n or y < 0:
        return False
    if graph[x][y] == 1:
        global count
        count += 1
        graph[x][y] = 0
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            dfs(nx, ny)
        return True
    return False

n = int(input())
graph = [[0]*n for _ in range(n)]
for i in range(n):
    graph[i] = list(map(int, input().strip()))
for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            ans.append(count)
            result += 1
            count = 0
print(result)
for s in sorted(ans):
    print(s)
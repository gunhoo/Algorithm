import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<m and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                q.append([nx, ny])

m,n = map(int, input().split())
graph = []
q = deque([])
dx = [1,-1,0,0]
dy = [0,0,1,-1]
ans = 0

for _ in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            q.append([i,j])

bfs()

for i in graph:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    ans = max(ans, max(i))
print(ans-1)
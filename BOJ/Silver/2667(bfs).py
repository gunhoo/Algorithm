from collections import deque
import sys
input = sys.stdin.readline

def bfs(grpah, a, b):
    q = deque()
    q.append([a, b])
    graph[a][b] = 0
    count = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0<=nx<n and 0<=ny<n and graph[nx][ny] == 1:
                graph[nx][ny] = 0
                count += 1
                q.append([nx, ny])
    return count

n = int(input())
graph = [[0]*n for _ in range(n)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]
ans = []
for i in range(n):
    graph[i] = list(map(int, input().strip()))
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            ans.append(bfs(graph, i, j))
print(len(ans))
for s in sorted(ans):
    print(s)
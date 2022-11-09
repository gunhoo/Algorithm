import sys
input = sys.stdin.readline
from collections import deque

def bfs(x):
    q = deque()
    q.append(x)
    while q:
        x = q.popleft()
        for i in range(1, n_com+1):
            if graph[x][i] == 1 and visited[i] == 0:
                q.append(i)
                visited[i] = 1
    return visited.count(1)

n_com = int(input())
lines = int(input())
graph = [[0]*(n_com+1) for _ in range(n_com+1)]
visited = [0]*(n_com+1)

for _ in range(lines):
    x, y = map(int, input().split())
    graph[x][y], graph[y][x] = 1,1

print(bfs(1)-1)
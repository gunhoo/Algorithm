import sys
input = sys.stdin.readline
from collections import deque

def bfs(v):
    q = deque()
    q.append(v)
    bfs_visit[v] = 1
    while q:
        v = q.popleft()
        print(v, end=" ")
        for i in range(1, n+1):
            if bfs_visit[i] == 0 and graph[v][i] == 1:
                q.append(i)
                bfs_visit[i] = 1

def dfs(v):
    dfs_visit[v] = 1
    print(v, end=" ")
    for i in range(1, n+1):
        if dfs_visit[i] == 0 and graph[v][i] == 1:
            dfs(i)

n, m, v = map(int, input().split())
graph = [[0]*(n+1) for _ in range(n+1)]
dfs_visit, bfs_visit = [0]*(n+1), [0]*(n+1)

for _ in range(m):
    x, y = map(int, input().split())
    graph[x][y], graph[y][x] = 1, 1

dfs(v)
print()
bfs(v)
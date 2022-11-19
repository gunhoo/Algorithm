import sys
input = sys.stdin.readline
from collections import deque

def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = 1
    while q:
        x = q.popleft()
        for i in graph[x]:
            if visited[i] ==0:
                q.append(i)
                visited[i] = x

n = int(input())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
for _ in range(n-1):
    p, c = map(int, input().split())
    graph[p].append(c)
    graph[c].append(p)

bfs(1)
for i in range(2, n+1):
    print(visited[i])
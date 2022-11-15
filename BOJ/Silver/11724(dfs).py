import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = 1
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i)


n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
ans = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(1, n+1):
    if visited[i] == 0:
        dfs(i)
        ans += 1

print(ans)
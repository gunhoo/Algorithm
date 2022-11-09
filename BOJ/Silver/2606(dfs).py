import sys
input = sys.stdin.readline

def dfs(x):
    visited[x] = 1
    for i in range(n+1):
        if visited[i] == 0 and graph[x][i] == 1:
            visited[i] = 1
            dfs(i)
    return(visited.count(1)-1)

n = int(input())
lines = int(input())
graph = [[0]*(n+1) for _ in range(n+1)]
visited=[0]*(n+1)

for _ in range(lines):
    x, y = map(int, input().split())
    graph[x][y],graph[y][x] = 1, 1

print(dfs(1))
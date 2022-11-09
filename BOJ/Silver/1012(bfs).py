import sys
input = sys.stdin.readline
from collections import deque

dx, dy = [-1,1,0,0], [0,0,-1,1]

def bfs(x, y):
    q = deque([])
    q.append([x,y])
    graph[x][y] = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m and graph[nx][ny] ==1:
                graph[nx][ny] = 0
                q.append([nx, ny])

T = int(input())
for test_case in range(0,T):
    ans = 0
    m,n,k = map(int, input().split())
    graph = [[0]*m for _ in range(n)]

    for _ in range(0,k):
        x, y = map(int, input().split())
        graph[y][x] = 1

    for i in range(0,n):
        for j in range(0,m):
            if graph[i][j] == 1:
                bfs(i,j)
                ans += 1
    print(ans)
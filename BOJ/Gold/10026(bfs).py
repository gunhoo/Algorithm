import sys
input = sys.stdin.readline
from collections import deque

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs(a,b, color, idx):
    q = deque()
    q.append([a,b])
    visited[a][b] = 1-idx
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<t and 0<=ny<t and image[nx][ny] == color and visited[nx][ny] == idx:
                q.append([nx,ny])
                visited[nx][ny]=1-idx
t = int(input())
image = []
for test_case in range(t):
    image.append(list(map(str, input().strip())))
visited = [[0]*t for _ in range(t)]

ans = 0
dis_ans = 0
for i in range(t):
    for j in range(t):
        if visited[i][j] != 1:
            bfs(i, j, image[i][j], 0)
            ans += 1
for i in range(t):
    for j in range(t):
        if image[i][j] == "G":
            image[i][j] = "R"
for i in range(t):
    for j in range(t):
        if visited[i][j] != 0:
             bfs(i, j, image[i][j], 1)
             dis_ans += 1

print(ans, dis_ans)

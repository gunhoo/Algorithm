import sys
input = sys.stdin.readline
from collections import deque

dx = [1,1,0,-1,-1,-1,0,1]
dy = [0,-1,-1,-1,0,1,1,1]

def bfs(a, b):
    q = deque()
    q.append([a, b])
    island_map[a][b] = 0
    while q:
        x, y = q.popleft()
        for i in range(8):
            nx, ny = x + dx[i], y + dy[i]
            if 0<=nx<h and 0<=ny<w and island_map[nx][ny] == 1:
                q.append([nx, ny])
                island_map[nx][ny] = 0

while True:
    ans = 0
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    if h == 1:
        a = int(input())
        if a == 0:
            ans = 0
        else:
            ans = 1
        print(ans)
    else:
        island_map = []
        visited = [[0]*(w) for _ in range(h)]
        for i in range(h):
            island_map.append(list(map(int, input().split())))
        for i in range(h):
            for j in range(w):
                if island_map[i][j] == 1:
                    bfs(i, j)
                    ans += 1
        print(ans)
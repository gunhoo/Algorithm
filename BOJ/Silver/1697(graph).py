from collections import deque
n, k = map(int, input().split())

max = 100000
distance = [0]*(max+1)
def bfs():
    q = deque()
    q.append(n)
    while q:
        v = q.popleft()
        if v == k:
            print(distance[v])
            break
        for i in (v-1, v+1, 2*v):
            if 0<=i<=max and not distance[i]:
                distance[i] = distance[v]+1
                q.append(i)

bfs()
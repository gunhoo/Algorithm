import sys
input = sys.stdin.readline

def get_smallest_node():
    min_v = 11
    index = 0
    for i in range(1, n+1):
        if distance[i] < min_v and visited[i] == 0:
            min_v = distance[i]
            index = i
    return index

def dijkstra(start):
    distance[start] = 0
    visited[start] = 1
    for i in graph[start]:
        distance[i[0]] = i[1]
    for _ in range(n-1):
        next_node = get_smallest_node()
        visited[next_node] = 1
        for j in graph[next_node]:
            if distance[next_node] + j[1] < distance[j[0]]:
                distance[j[0]] = distance[next_node] + j[1]

n, e = map(int, input().split())
k = int(input())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
distance = [11]*(n+1)
for _ in range(e):
    u,v,w = map(int, input().split())
    graph[u].append((v,w))

dijkstra(k)

for i in range(1, n+1):
    if distance[i] != 11:
        print(distance[i])
    else:
        print("INF")
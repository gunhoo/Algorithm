import sys
input = sys.stdin.readline

n = int(input())

dp = [[0]*3 for _ in range(n)]
graph = []
for i in range(n):
     graph.append(list(map(int, input().split())))
dp[0] = graph[0]

for i in range(1, n):
    for j in range(3):
        dp[i][j] = min(dp[i-1][j-1], dp[i-1][j-2]) + graph[i][j]

print(min(dp[n-1]))
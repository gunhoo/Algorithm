n, k = map(int, input().split())
w, v = [0]*n,[0]*n
dp = [[0]*(k+1) for _ in range(n+1)]

for i in range(n):
    w[i], v[i] = map(int, input().split())

for i in range(1, n+1):
    for j in range(1, k+1):
        if w[i-1]<=j:
            dp[i][j] = max(v[i-1]+dp[i-1][j-w[i-1]] , dp[i-1][j])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[-1][-1])

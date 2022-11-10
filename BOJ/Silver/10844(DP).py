import sys
input = sys.stdin.readline

n = int(input())
dp = [[0]*10 for _ in range(n)]
for i in range(1, 10):
    dp[0][i] = 1
for i in range(1, n):
    for j in range(10):
        if j == 0:
            dp[i][j] = dp[i-1][1]
        elif j == 9:
            dp[i][j] = dp[i-1][8]
        else:
            dp[i][j] = dp[i-1][j-1]+ dp[i-1][j+1]
print(sum(dp[n-1])%1000000000)
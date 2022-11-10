import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(T):
    dp = [[1, 0], [0, 1]]
    n = int(input())
    if n == 0 or n ==1:
        print(dp[n][0], dp[n][1])
    else:
        for i in range(2, n+1):
            dp.append([dp[i-2][0]+dp[i-1][0], dp[i-2][1]+dp[i-1][1]])
        print(dp[n][0], dp[n][1])
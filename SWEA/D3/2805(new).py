T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = [list(map(int, list(input().strip()))) for _ in range(n)]
    ans = 0
    for i in range(n//2+1):
        for j in range(n//2-i, n//2+i+1):
            ans += arr[i][j]+arr[n-i-1][j]
    ans -= sum(arr[n//2])
    print("#{} {}".format(test_case, ans))

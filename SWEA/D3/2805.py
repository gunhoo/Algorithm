T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = [0]*n
    sum = ''
    ans = 0

    for i in range(n):
        arr[i] = input()
    for i in range(0, n//2):
        sum += arr[i][n//2-i:n//2+i+1]
    for i in range(n//2, n):
        sum += arr[i][i-n//2:n-i+n//2]
    for i in sum:
        ans += int(i)

    print("#{} {}".format(test_case, ans))

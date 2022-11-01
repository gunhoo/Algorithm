
for test_case in range(1, 11):
    T = int(input())
    arr = [[0]*100 for i in range(100)]
    max = 0
    sum = 0

    for i in range(100):
        arr[i] = list(map(int, input().split()))

    for i in range(0,100):
        sum = 0
        for j in range(0, 100):
            sum += arr[i][j]
        if max < sum:
            max = sum
    for i in range(0,100):
        sum = 0
        for j in range(0, 100):
            sum += arr[j][i]
        if max < sum:
            max = sum
    # 대각선
    sum = 0
    for i in range(0,100):
        sum += arr[i][99-i]
        if max < sum:
            max = sum

    sum = 0
    for i in range(0,100):
        sum += arr[i][i]
        if max < sum:
            max = sum

    print("#{} {}".format(test_case, max))

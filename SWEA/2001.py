T = int(input())


for test_case in range(1, T + 1):
    arr = []
    n, m = map(int, input().split())
    max = 0
    for i in range(n):
        arr += list(map(int, input().split()))
    for y in range(0, n-m+1):
        for x in range(0, n-m+1):
            sum = 0
            for i in range(0,m):
                for j in range(0,m):
                    sum += arr[y*n+x+i*n+j]
            if sum >= max:
                max = sum

    print("#{} {}".format(test_case, max))

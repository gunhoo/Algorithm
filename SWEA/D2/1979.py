T = int(input())

for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    arr = [[0]*n for i in range(n)]
    len_arr = []

    for i in range(0, n):
        arr[i] = list(map(int, input().split()))

    for i in range(0, n):
        len = 0
        for j in range(0,n):
            if arr[i][j] == 1:
                len += 1
            else:
                if len != 0:
                    len_arr.append(len)
                    len = 0
        if len != 0:
            len_arr.append(len)

    for i in range(0, n):
        len = 0
        for j in range(0,n):
            if arr[j][i] == 1:
                len += 1
            else:
                if len != 0:
                    len_arr.append(len)
                    len = 0
        if len != 0:
            len_arr.append(len)

    print("#{} {}".format(test_case,len_arr.count(k)))

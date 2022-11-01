
for test_case in range(1, 11):
    length = int(input())
    ans = 0
    arr = [[]*8 for _ in range(8)]
    r_arr = [[]*8 for _ in range(8)]

    for i in range(8):
        arr[i] = input()

    for i in range(0,8):
        for j in range(0,9-length):
            if arr[i][j:(j+length)] == arr[i][j:(j+length)][::-1]:
                ans += 1
    for i in range(0,8):
        for j in range(0,8):
            r_arr[i] += arr[j][i]

    for i in range(0,8):
        for j in range(0,9-length):
            if r_arr[i][j:(j+length)] == r_arr[i][j:(j+length)][::-1]:
                ans += 1

    print("#{} {}".format(test_case, ans))

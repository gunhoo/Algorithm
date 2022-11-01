#문제풀이 시간 : 13:55 ~ 15:24(1h29m)

for test_case in range(1, 11):
    ans = 0

    h = int(input())
    arr = [[0]*h for _ in range(h)]

    for i in range(0, h):
        arr[i] = list(map(int, input().split()))

    # 1 : N / 2 : S
    for i in range(0,h):
        q = []
        for j in range(0, h):
            if arr[j][i] != 0:
                q.append(arr[j][i])

        while len(q)>0:
            if q[0] == 2:
                del q[0]
            if q[-1] == 1:
                del q[-1]
            if q[0] != 2 and q[-1] != 1:
                break
        for k in range(0, len(q)-1):
            if q[k] == 1 and q[k+1] == 2:
                ans += 1

    print("#{} {}".format(test_case, ans))

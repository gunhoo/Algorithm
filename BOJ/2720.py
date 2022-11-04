T = int(input())
coin = [25, 10, 5, 1]
for test_case in range(T):
    ans = [0]*4
    change = int(input())

    for i in range(4):
        if change // coin[i] >= 1:
            ans[i] = change // coin[i]
            change -= (change // coin[i])*coin[i]
    for j in ans:
        print(j, end = " ")
    print()

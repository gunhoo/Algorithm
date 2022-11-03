T = int(input())

for test_case in range(1, T+1):
    money = int(input())
    curr = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    ans = [0,0,0,0,0,0,0,0]

    for i in range(8):
        if money // curr[i] >= 1:
            ans[i] = money // curr[i]
            money -= (money // curr[i])*curr[i]
    print("#{}".format(test_case))
    for i in ans:
        print(i, end = " ")
    print()

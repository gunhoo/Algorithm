T = int(input())
ans = []
answer = []

for test_case in range(1, T + 1):
    num = int(input())
    comp = [2,3,5,7,11]
    i = 0
    ans = [0,0,0,0,0]

    while i < 5:
        if num % comp[i] == 0:
            ans[i] += 1
            num /= comp[i]
        else:
            i += 1
    print("#{}".format(test_case), end=" ")
    for i in range(0,5):
        print("{}".format(ans[i]), end=" ")
    print()

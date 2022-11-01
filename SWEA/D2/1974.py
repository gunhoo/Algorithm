T = int(input())
def factorial(num):
    res = 1
    for i in range(1, num+1):
        res *= i
    return res

for test_case in range(1, T + 1):
    arr = [[0]*9 for i in range(9)]

    for i in range(0,9):
        arr[i] = list(map(int, input().split()))

    ans = 1
    for i in range(0,9):
        sum = 1

        # check row
        for j in range(0,9):
            sum *= arr[i][j]
        if sum != factorial(9):
            ans = 0
            #print("{}'s row error{}".format(j, sum))
            break
        sum = 1
        #check col
        for j in range(0,9):
            sum *= arr[j][i]
        if sum != factorial(9):
            ans = 0
            #print("{}'s row error{}".format(i, sum))
            break
        sum = 1
        #check square
        if (i)%3 == 0:
            for j in range(0,3):
                sum *= arr[i][j] * arr[i+1][j] * arr[i+2][j]
            if sum != factorial(9):
                ans = 0
                #print("{}'s square error{}".format(i, sum))
                break
    print("#{} {}".format(test_case, ans))

T = int(input())
for test_case in range(1, T+1):
    n = int(input())
    arr = [[0]*n for _ in range(n)]
    for i in range(n):
        arr[i] = list(map(int, input().split()))
    #print(circle(arr))
    print("#{}".format(test_case))
    for i in range(0,n):
        #for k in range(3):
        for j in range(0,n):
            print("{}".format(arr[-j-1][i]), end="")
        print(" ", end = "")
        for j in range(0,n):
            print("{}".format(arr[-i-1][-j-1]), end="")
        print(" ", end = "")
        for j in range(0,n):
            print("{}".format(arr[j][-i-1]), end="")
        print()

T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = ""
    for i in range(n):
        c, k = map(str, input().split())
        arr += c*int(k)

    print("#{}".format(test_case))
    for i in range(len(arr)):
        print(arr[i], end="")
        if (i+1)%10 == 0 :
            print()
    print()

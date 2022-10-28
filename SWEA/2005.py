T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    arr = [1]
    cnt = 0

    for i in range(1, n):
        arr.append(1)
        for j in range(1, i):
            arr.append(arr[len(arr)-i-1]+arr[len(arr)-i])
            #print("i{}j{}arr[i+j]{}".format(i,j,arr[i+j]))
        arr.append(1)
    print("#{}".format(test_case))
    for i in range(1, n+1):
        for j in range(i):
            print(arr[cnt], end = " ")
            cnt += 1
        print()

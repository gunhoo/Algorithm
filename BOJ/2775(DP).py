T = int(input())

for test_case in range(T):
    k = int(input())
    n = int(input())
    arr = [ _ for _ in range(0,n+1)]
    for i in range(0, (k)*(n+1)):
        if i % (n+1) == 0:
            arr.append(0)
        else:
            arr.append(arr[-1]+arr[i])
    print(arr[-1])

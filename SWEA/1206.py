for test_case in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    ans = 0
    i = 2
    while i < n-1:
        if  arr[i-2] < arr[i] and arr[i-1] < arr[i] and arr[i] > arr[i+1] and arr[i] > arr[i+2]:
            ans += min(arr[i]-arr[i-2], arr[i]-arr[i-1], arr[i]-arr[i+1], arr[i]-arr[i+2])
            i += 2
        else: i += 1

    print("#{} {}".format(test_case, ans))

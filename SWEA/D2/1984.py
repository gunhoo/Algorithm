T = int(input())

for test_case in range(1, T + 1):
    arr = list(map(int, input().split()))
    sum = 0
    max = 0
    min = 10000
    for i in range(0,len(arr)):
        if arr[i]> max:
            max = arr[i]
        elif arr[i] < min:
            min = arr[i]

    arr.remove(max)
    arr.remove(min)

    for i in range(len(arr)):
        sum += arr[i]

    print("#{} {}".format(test_case, round(sum/8)))

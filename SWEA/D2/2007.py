T = int(input())

for test_case in range(1, T + 1):
    str = input()
    arr = []
    for i in range(len(str)):
        arr.append(str[i])
    for i in range(1, len(arr)):
        if arr[:i] == arr[i:2*i] and arr[2*i:]==arr[:len(arr)-2*i]:
            ans = i
            break
    print("#{} {}".format(test_case, ans))

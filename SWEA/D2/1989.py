T = int(input())

for test_case in range(1, T + 1):
    str = input()
    arr = []
    ans = 0

    for i in range(len(str)):
        arr.append(str[i])
    if arr[:len(arr)//2] == arr[-1:-(len(arr)+1)//2:-1]: #and arr[2*i:]==arr[:len(arr)-2*i]:
        ans = 1
    print("#{} {}".format(test_case, ans))

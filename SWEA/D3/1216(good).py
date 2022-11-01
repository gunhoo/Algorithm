import sys
sys.stdin = open("1216.txt", "r")

for test_case in range(1, 11):
    T = int(input())
    max = 1
    arr = [[]*100 for _ in range(100)]
    r_arr = [[]*100 for _ in range(100)]

    for i in range(100):
        arr[i] = input()

    i = 0
    while i < 100:#for i in range(0,100):
        j = 0
        while j < 100:#for j in range(0,100-max):
            k = 1
            while k < 100-max:
                if arr[i][j:j+max+k] == arr[i][j:j+max+k][::-1] and len(arr[i][j:j+max+k]) > max:
                    max = len(arr[i][j:j+max+k])
                k += 1
            j += 1
        i += 1

    for i in range(0,100):
        for j in range(0,100):
            r_arr[i] += arr[j][i]

    i = 0
    while i < 100:#for i in range(0,100):
        j = 0
        while j<100:#for j in range(0,100-max):
            k = 1
            while k < 100-max:
                if r_arr[i][j:j+max+k] == r_arr[i][j:j+max+k][::-1] and len(r_arr[i][j:j+max+k]) > max:
                    max = len(r_arr[i][j:j+max+k])
                k += 1
            j += 1
        i += 1

    print("#{} {}".format(T, max))

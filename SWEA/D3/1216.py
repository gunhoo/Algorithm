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
            if arr[i][j:j+max+1] == arr[i][j:j+max+1][::-1] and len(arr[i][j:j+max+1]) > max:
                max = len(arr[i][j:j+max+1])
                #print("1. i: {}, j: {}, arr max value updated: {}".format(i, j, max))
                j = -1
                i = 0
            j += 1
        i += 1
    i = 0
    for i in range(0,100):
        j = 0
        while j < 100:#for j in range(0,100-max):
            if arr[i][j:j+max+2] == arr[i][j:j+max+2][::-1] and len(arr[i][j:j+max+2]) > max:
                max = len(arr[i][j:j+max+2])
                #print("2. i: {}, j: {}, arr max value updated: {}".format(i, j, max))
                j = -1
            j += 1
    i = 0
    while i < 100:#for i in range(0,100):
        j = 0
        while j < 100:#for j in range(0,100-max):
            if arr[i][j:j+max+1] == arr[i][j:j+max+1][::-1] and len(arr[i][j:j+max+1]) > max:
                max = len(arr[i][j:j+max+1])
                #print("1. i: {}, j: {}, arr max value updated: {}".format(i, j, max))
                j = -1
                i = 0
            j += 1
        i += 1

    for i in range(0,100):
        for j in range(0,100):
            r_arr[i] += arr[j][i]
    i = 0
    while i < 100:#for i in range(0,100):
        j = 0
        while j<100:#for j in range(0,100-max):
            if r_arr[i][j:j+max+1] == r_arr[i][j:j+max+1][::-1] and len(r_arr[i][j:j+max+1]) > max:
                max = len(r_arr[i][j:j+max+1])
                #print("3. i: {}, j: {}, arr max value updated: {}".format(i, j, max))
                j = -1
                i = 0
            j += 1
        i += 1
    i = 0
    while i < 100:#for i in range(0,100):
        j = 0
        while j<100:#for j in range(0,100-max):
            if r_arr[i][j:j+max+2] == r_arr[i][j:j+max+2][::-1] and len(r_arr[i][j:j+max+1]) > max:
                max = len(r_arr[i][j:j+max+1])
                #print("4. i: {}, j: {}, arr max value updated: {}".format(i, j, max))
                j = -1
                i = 0
            j += 1
        i += 1
    i = 0
    while i < 100:#for i in range(0,100):
        j = 0
        while j<100:#for j in range(0,100-max):
            if r_arr[i][j:j+max+1] == r_arr[i][j:j+max+1][::-1] and len(r_arr[i][j:j+max+1]) > max:
                max = len(r_arr[i][j:j+max+1])
                #print("3. i: {}, j: {}, arr max value updated: {}".format(i, j, max))
                j = -1
                i = 0
            j += 1
        i += 1
    print("#{} {}".format(T, max))

T =int(input())

for test_case in range(1, T+1):
    numbers, exchange = map(str, input().split())
    arr = list(map(int, numbers.strip()))
    # cnt = 0
    # idx = 0
    #
    # for i in range(int(exchange)):
    #     if arr[idx] != max(arr[idx:]):
    #         tmp = arr[idx]
    #         arr[idx] = max(arr)
    #         print(arr.index(max(arr[-1:])-1))
    #         arr[-arr.index(max(arr[-1-idx:])-1)] = tmp
    #         print("exchanged. arr: {}".format(arr))
    #     else:
    #         cnt += 1
    #
    #     if idx == (len(arr)-2): pass
    #     else : idx += 1
    # for j in range(cnt):


    print(arr)

T= int(input())

arr = [[1,0], [0,1]]

for i in range(2,T+1):
    arr.append([arr[0][0]+arr[1][0], arr[0][1]+arr[1][1]])
    del(arr[0])
print("{} {}".format(arr[-1][0], arr[-1][1]))

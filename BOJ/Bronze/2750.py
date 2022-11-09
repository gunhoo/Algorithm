T = int(input())
arr = []
for i in range(T):
    arr.append(int(input()))
arr.sort()
for j in range(T):
    print(arr[j])
student = int(input())
arr = list(map(int, input().split()))
new = []
for i in range(len(arr)):
    new.insert(-arr[i]+i,  i+1)
for i in range(len(new)-1):
    print("{}".format(new[i]), end=" ")
print("{}".format(new[i+1]), end="")

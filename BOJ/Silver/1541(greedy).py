from collections import deque
q = deque()

input_arr = input().split("-")
ans = 0
tmp = input_arr[0].split("+")
for j in tmp:
    ans += int(j)
for i in range(1, len(input_arr)):
    tmp = input_arr[i].split("+")
    for j in tmp:
        ans -= int(j)
print(ans)
import sys
input = sys.stdin.readline
from collections import deque

q = deque()
nums = deque()
start = 1
for i in range(int(input())):
    num = int(input())
    while start <= num:
        nums.append(start)
        q.append("+")
        start += 1
    if nums[-1] == num:
        nums.pop()
        q.append("-")
    else:
        print("NO")
        exit()
while q:
    print(q.popleft())
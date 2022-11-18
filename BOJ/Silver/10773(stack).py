import sys
input = sys.stdin.readline
from collections import deque

q = deque()
for _ in range(int(input())):
    num = int(input())
    if num == 0:
        q.pop()
    else:
        q.append(num)
print(sum(q))
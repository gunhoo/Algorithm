import sys
input=sys.stdin.readline
from collections import deque

T = int(input())
q = deque([])
for test_case in range(T):
    ps = input().split()
    if ps[0] == "push":
        q.append(int(ps[-1]))
    elif ps[0] == "pop":
        if len(q) != 0:
            print(q.popleft())
        else:
            print(-1)
    elif ps[0] == "size":
        print(len(q))
    elif ps[0] == "empty":
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif ps[0] == "front":
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif ps[0] == "back":
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])

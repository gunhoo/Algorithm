import sys
input=sys.stdin.readline

T = int(input())
q = []
for test_case in range(T):
    ps = input().split()
    if ps[0] == "push":
        q.append(int(ps[-1]))
    elif ps[0] == "pop":
        if len(q) != 0:
            print(q.pop(0))
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

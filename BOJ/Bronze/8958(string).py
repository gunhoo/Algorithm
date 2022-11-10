import sys
input = sys.stdin.readline
from collections import deque

t = int(input())

for test_case in range(t):
    score = 0
    q = deque()
    ans = input()
    for i in range(len(ans)):
        if ans[i] == "O":
            q.append("O")
            score += q.count("O")
        else:
            q = deque()
    print(score)
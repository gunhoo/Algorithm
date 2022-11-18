import sys
input = sys.stdin.readline
from collections import deque

n,m = map(int, input().split())
ans = [[] for _ in range(n+1)]
indegree = [0 for _ in range(n+1)]
q = deque()

for _ in range(m):
    a, b = map(int, input().split())
    ans[a].append(b)
    indegree[b] += 1

for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)

while q:
    student = q.popleft()
    print(student, end = " ")
    for back in ans[student]:
        indegree[back] -= 1
        if indegree[back] == 0:
            q.append(back)
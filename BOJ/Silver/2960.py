import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())
if n == 2 and k==1:
    print(2)
    exit()
elif n==2 and k==0:
    print(0)

q = []
ans = deque()
idx = 0
for i in range(2, n+1):
    q.append(i)

while len(ans) < k:
    idx = q.pop(0)
    if not idx in ans:
        for i in range(1, n//idx+1):
            if not idx*i in ans:
                ans.append(idx*i)
print(ans[k-1])
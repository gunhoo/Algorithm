from collections import deque

c_a = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]


q = (deque(map(str, input().strip())))
ans = len(q)
while q:
    start = q.popleft()
    if start in ("cdlnsz") and len(q) != 0:
        next = q.popleft()
        if start + next == "dz" and len(q)!=0:
            end = q.popleft()
            if start+next+end in c_a:
                ans -= 2
            else:
                q.insert(0, end)
                q.insert(0, next)
        elif start + next in c_a:
            ans -= 1
        else:
            q.insert(0, next)
print(ans)

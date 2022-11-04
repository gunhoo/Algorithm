N = int(input())
hs = list(map(int, input().split()))
max_h = 0
ans = 0
cnt = 0

for h in hs:
    if h > max_h:
        max_h = h
        cnt = 0
    else:
        cnt += 1
    ans = max(ans, cnt)

print(ans)

import sys
input = sys.stdin.readline

T = int(input())
ans = 0
for _ in range(T):
    sent = input().strip()
    q = [sent[0]]
    sum = 1
    for i in range(1, len(sent)):
        if sent[i] != sent[i-1] and q.count(sent[i]) != 0:
            sum = 0
            break
        elif sent[i] != sent[i-1] and q.count(sent[i]) == 0:
            q.append(sent[i])
    ans += sum
print(ans)
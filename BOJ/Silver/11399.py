n = int(input())
p = list(map(int, input().split()))
p.sort()
ans = 0
answer = []
for i in p:
    ans += i
    answer.append(ans)
print(sum(answer))
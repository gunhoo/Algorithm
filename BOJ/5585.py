change = 1000-int(input())
coin = [500, 100, 50, 10, 5, 1]
ans = 0
for i in range(6):
    if change // coin[i] >= 1:
        ans += change // coin[i]
        change -= (change // coin[i])*coin[i]
print(ans)

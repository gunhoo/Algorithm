raizer = input()
ans = 0
q = []

for i in range(len(raizer)):
    if raizer[i] == '(':
        q.append(raizer[i])
    else:
        q.pop()
        if raizer[i-1] == ')':
            ans += 1
        else:
            if len(q) != 0:
                ans += len(q)

print(ans)

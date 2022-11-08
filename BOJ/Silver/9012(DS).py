T = int(input())

for test_case in range(T):
    ps = input()
    q = ["0"]
    ans = "YES"
    for i in range(len(ps)):
        if ps[i] == "(":
            q.append(ps[i])
        else:
            if q[-1] == "(":
                q.pop()
            else:
                ans = "NO"
                break
    if q[-1] != "0":
        ans = "NO"
    print(ans)

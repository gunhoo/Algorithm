test_case = 1
while True:
    l, p, v = map(int, input().split())
    if l == 0 and p == 0 and v == 0:
        break
    else:
        ans = 0
        ans = (v//p)*l
        if v%p >= l:
            ans += l
        else:
            ans += v%p
        print("Case {}: {}".format(test_case, ans))
        test_case += 1

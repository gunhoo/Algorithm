for test_case in range(1, 11):
    dump = int(input())
    hs = list(map(int, input().split()))

    for i in range(dump):
        hs[hs.index(max(hs))] -= 1
        hs[hs.index(min(hs))] += 1

    print("#{} {}".format(test_case, max(hs)-min(hs)))

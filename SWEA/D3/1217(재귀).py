def sq(n, m):
    if m == 0:
        return 1
    return n*sq(n, m-1)


for test_case in range(1, 11):
    T = int(input())
    n, m = map(int, input().split())
    print("#{} {}".format(T, sq(n, m)))

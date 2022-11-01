for test_case in range(1, 11):
    T = int(input())
    n, m = map(int, input().split())
    print("#{} {}".format(T, pow(n, m)))

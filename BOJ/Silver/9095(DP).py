def check(n):
    if n == 1:
        return 1
    elif n==2:
        return 2
    elif n==3:
        return 4
    elif n == 0:
        return 0
    else :
        return check(n-1)+check(n-2)+check(n-3)

T = int(input())

for test_case in range(T):
    n = int(input())
    print(check(n))

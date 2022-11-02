def fac(n):
    sum = 1
    for i in range(1, n+1):
        sum *= i
    return sum

T = int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())
    print(fac(m)//(fac(m-n)*fac(n)))

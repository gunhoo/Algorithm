def pow(b, p):
    if p == 0:
        return 1
    half = pow(b, p//2)
    if p %2 == 0:
        return ((half%1234567891)*(half%1234567891))%1234567891
    else:
        return ((((half%1234567891)*(half%1234567891))%1234567891)*b)%1234567891


T = int(input())

for test_case in range(1, T+1):
    n, r = map(int, input().split())

    fac = [1]*(n+1)
    for i in range(1, n+1):
        fac[i] = (fac[i-1]*i) % 1234567891

    u = fac[n]%1234567891
    d = ((fac[n-r]%1234567891)*(fac[r]%1234567891))%1234567891
    ans = (u*pow(d, 1234567889))%1234567891



        # for j in range(2, n-r+1):
        #     devider *= j
        #     if devider % 1234567891 == 0:
        #         sum = 0
        #         break

    print("#{} {}".format(test_case, ans))

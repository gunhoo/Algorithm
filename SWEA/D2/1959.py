T = int(input())
for test_case in range(1, T+1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    if len(b)-len(a)>=0:
        sum = [0]*(len(b)-len(a)+1)
        for i in range(len(b)-len(a)+1):
            for j in range(len(a)):
                sum[i] += a[j]*b[j+i]
    else:
        sum = [0]*(-len(b)+len(a)+1)
        for i in range(-len(b)+len(a)+1):
            for j in range(len(b)):
                sum[i] += a[j+i]*b[j]
    print("#{} {}".format(test_case, max(sum)))

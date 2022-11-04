global ans
ans = 0

def dp_fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        fib_arr = [0,1]
        for i in range(2, n+1):
            fib_arr.append(fib_arr[i-1]+fib_arr[i-2])
        return fib_arr[n]

def recur_fibo(n):
    global ans
    if n == 0:
        return 0
    elif n == 1 or n == 2:
        ans += 1
        return 1
    else:
        return recur_fibo(n-1)+recur_fibo(n-2)

n = int(input())
recur_fibo(n)
print("{} {}".format(ans, n-2))

def fibo(n):
    fib_arr = [0,1]
    for i in range(2, n+1):
        fib_arr.append(fib_arr[i-1]+fib_arr[i-2])
    return fib_arr[n]

n = int(input())

print(fibo(n))

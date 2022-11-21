arr = [1, 2]

def fibo(n):
    for i in range(2, n):
        arr.append(arr[i-1]+arr[i-2])
    return arr[n-1]

def solution(n):

    if n > 2:
        return(fibo(n)%1234567)
    else:
        return arr[n-1]
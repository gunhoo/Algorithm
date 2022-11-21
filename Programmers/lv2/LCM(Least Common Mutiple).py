def lcm(a, b):
    if a % b == 0 and b&a == 0:
        if a>b:
            return a
        else:
            return b
    elif a % b == 0 and b & a != 0:
        return a
    elif a%b !=0 and b%a == 0:
        return b
    else:
        for i in range(2, a//2+1):
            if a % i == 0 and b % i == 0:
                return lcm(a//i, b//i)*i
        return a*b

def solution(arr):
    answer = 1
    for i in arr:
        answer = lcm(i, answer)
    return answer
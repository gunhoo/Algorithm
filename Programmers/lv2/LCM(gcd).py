from fractions import gcd

def lcm(i, answer):
    return i*answer / gcd(i, answer)

def solution(arr):
    answer = 1
    for i in arr:
        answer = lcm(i, answer)
    return answer
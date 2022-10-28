

def solution(n):
    a=0
    b=1
    for i in range(n):
        a, b = b, a+b

    answer = a%1234567
    return answer

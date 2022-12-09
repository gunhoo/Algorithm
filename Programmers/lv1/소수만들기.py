from itertools import combinations

def sosu(num):
    for i in range(2, num//2):
        if num % i == 0:
            return False
    return True

def solution(nums):
    answer = 0
    for a, b,c in combinations(nums, 3):
        if sosu(a+b+c):
            answer += 1

    return answer
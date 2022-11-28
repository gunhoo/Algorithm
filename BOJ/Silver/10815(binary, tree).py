import sys
input = sys.stdin.readline

def binary(v, start, end):
    if start>end:
        return 0
    m = (start + end)//2
    if card_list[m] == v:
        return 1
    elif card_list[m] < v:
        return binary(v, m+1, end)
    else:
        return binary(v, start, m-1)

n = int(input())
card_list = list(map(int, input().split()))
card_list.sort()

m = int(input())
q_list = list(map(int, input().split()))

for i in q_list:
    if card_list[0] > i or card_list[-1] < i:
        print(0, end = " ")
    else:
        print(binary(i, 0, n), end = " ")
from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

n = int(input())
n_arr = list(map(int, input().split()))
n_arr.sort()
m = int(input())
m_arr =  list(map(int, input().split()))

for i in m_arr:
    print(bisect_right(n_arr, i)-bisect_left(n_arr, i), end = " ")
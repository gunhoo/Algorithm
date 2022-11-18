import sys
input = sys.stdin.readline

n = int(input())
n_arr = set(list(input().split()))
m = int(input())
m_arr = list(input().split())

for i in m_arr:
    if i in n_arr:
        print(1)
    else:
        print(0)
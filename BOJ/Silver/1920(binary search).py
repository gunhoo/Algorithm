import sys
input = sys.stdin.readline

def binary(l, start, end):
    if start > end:
        return 0
    m = (start+end)//2
    if l == n_arr[m]:
        return 1
    elif l<n_arr[m]:
        return binary(l, start, m-1)
    else:
        return binary(l, m+1, end)

n = int(input())
n_arr = sorted(list(map(int, input().split())))
m = int(input())
m_arr = (list(map(int, input().split())))
for i in m_arr:
    start = 0
    end = len(n_arr)-1
    print(binary(i, start, end))
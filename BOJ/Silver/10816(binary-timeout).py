import sys
input = sys.stdin.readline

def binary(start, end, l):
    global ans
    ans = 0
    m = (start+end)//2
    if start == m and n_arr[m] != l:
        return ans
    if n_arr[m] == l:
        ans += 1
        idx_l, idx_r = m-1, m+1
        while idx_l >= 0 and n_arr[idx_l] == l:
            ans += 1
            idx_l -= 1
        while idx_r < len(n_arr) and n_arr[idx_r] == l:
            ans += 1
            idx_r += 1
        return ans
    elif n_arr[m] < l:
        binary(m, end, l)
    else:
        binary(start, m, l)

n = int(input())
n_arr = list(map(int, input().split()))
n_arr.sort()
m = int(input())
m_arr =  list(map(int, input().split()))

start = 0
end = len(n_arr)-1
ans = 0

for i in m_arr:
    binary(start, end, i)
    print("{}".format(ans), end = " ")

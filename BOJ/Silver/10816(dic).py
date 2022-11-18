import sys
input = sys.stdin.readline

n = int(input())
n_arr = list(map(int, input().split()))

m = int(input())
m_arr =  list(map(int, input().split()))

dic = {}

for i in n_arr:
    if i in dic:
        dic[i] = dic[i] + 1
    else:
        dic[i] = 1

for i in m_arr:
    if i in dic:
        print(dic[i], end = " ")
    else:
        print(0, end = " ")
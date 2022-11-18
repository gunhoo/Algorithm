import sys
input = sys.stdin.readline

def dfs():
    if len(arr) == m:
        print(" ".join(map(str, arr)))
        return
    for i in range(1, n+1):
        if i not in arr:
            arr.append(i)
            dfs()
            arr.pop()

arr = []
n,m=map(int, input().split())
dfs()

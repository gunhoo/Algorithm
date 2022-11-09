import sys
input=sys.stdin.readline

T = int(input())
arr = []

for i in range(T):
    arr.append(int(input()))
for j in sorted(arr):
    sys.stdout.write(str(j)+'\n')
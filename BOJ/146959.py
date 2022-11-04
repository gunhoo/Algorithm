N = int(input())
h = list(map(int, input().split()))
arr = [0]*N

for i in range(N):
    ans = 0

    for j in range(i+1, N):
        if i>0 and h[i] < h[i-1]:
            break
        if h[i] > h[j]:
            ans += 1
        else: break
    arr[i] = ans
print(max(arr))

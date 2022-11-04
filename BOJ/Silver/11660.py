n,m = map(int, input().split())
n_arr = []
m_arr = []

for i in range(n):
    n_arr.append(list(map(int, input().split())))
for i in range(m):
    m_arr.append(list(map(int, input().split())))

for i in range(m):
    ans = 0
    for j in range(m_arr[i][1]-1, m_arr[i][3]):
        for k in range(m_arr[i][0]-1, m_arr[i][2]):
            ans += n_arr[j][k]
    print(ans)

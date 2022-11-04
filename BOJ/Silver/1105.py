l, r = input().split()

if len(l) != len(r):
    print(0)
else:
    ans = 0
    for i in range(len(l)):
        if l[i] != r[i]:
            break
        else:
            if l[i] == '8':
                ans+=1
    print(ans)

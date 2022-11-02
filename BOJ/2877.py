t = int(input())
ans = format(t+1, 'b')
ans = ans[1:]
print(ans.replace('0', '4').replace('1', '7'))

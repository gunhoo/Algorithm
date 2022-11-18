import sys
input = sys.stdin.readline

n = list(input().strip())
n.sort()
num_of_chr = {}

for c in n:
    num_of_chr[c] = n.count(c)

num_of_odd = 0
odd_c = ""
even_c = ""

for i in num_of_chr:
    if num_of_chr[i] % 2 == 1:
        num_of_odd += 1
        odd_c += i
    even_c += i*(num_of_chr[i]//2)
if num_of_odd>1:
    print("I'm Sorry Hansoo")
else:
    print(even_c+odd_c+even_c[::-1])
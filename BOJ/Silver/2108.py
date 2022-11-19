import sys
input = sys.stdin.readline
from collections import Counter

numbers = []
n = int(input())
for _ in range(n):
    numbers.append(int(input()))
#1
print(round(sum(numbers)/n))
#2
numbers.sort()
print(numbers[n//2])
#3
cnt_nums = Counter(numbers).most_common()
if len(cnt_nums)>1:
    if cnt_nums[0][1] == cnt_nums[1][1]:
        print(cnt_nums[1][0])
    else:
        print(cnt_nums[0][0])
else:
    print(cnt_nums[0][0])
#4
print(numbers[-1]-numbers[0])
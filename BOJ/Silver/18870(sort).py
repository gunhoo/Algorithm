import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))
sorted_numbers = sorted(set(numbers))
# dic 안쓰면 시간초과
dic_num = {sorted_numbers[i] : i for i in range(len(sorted_numbers))}
for i in numbers:
    print(dic_num[i], end = " ")
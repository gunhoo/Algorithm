from itertools import combinations

n, m = map(int, input().split())
card_list = list(map(int, input().split()))
tmp_max = 0
for card in combinations(card_list, 3):
    sum_card = sum(card)
    if tmp_max < sum_card <= m:
        tmp_max=sum_card
print(tmp_max)
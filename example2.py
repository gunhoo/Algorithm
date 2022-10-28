# T = int(input())
# # 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
# for test_case in range(1, T + 1):
#     sum = 0
#     price = []
#     day = int(input())
#     price = list(map(int, input().split()))
#     for day_case in range(0, day-1):
#         if price[day_case] < max(price[day_case+1:]):
#             sum += max(price[day_case+1:])-price[day_case]
#     print("#{0} {1}".format(test_case, sum))


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    sum = 0
    day = int(input())
    price = list(map(int, input().split()))
    max = price[-1]
    for i in range(day-2, -1, -1):
        if price[i] > max:
            max = price[i]s
        else:
            sum += max-price[i]
    print("#{0} {1}".format(test_case, sum))

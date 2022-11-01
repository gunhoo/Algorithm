T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    test_case = int(input())
    total = list(map(int, input().split()))
    total.sort()
    max_cnt = 0
    for n in range(len(total)):
        new_max_cnt = total.count(total[n]) #len([j for j in range(len(total) if j in total)])
        if new_max_cnt >= max_cnt:
            max_cnt = new_max_cnt
            answer = total[n]
    print("#{} {}".format(test_case, answer))

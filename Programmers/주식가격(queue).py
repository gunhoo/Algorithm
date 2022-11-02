from collections import deque

def solution(prices):
    answer = []
    prices = deque(prices)

    while prices:
        c = prices.popleft()
        cnt = 0

        for i in prices:
            if i < c:
                cnt += 1
                break
            cnt += 1
        answer.append(cnt)
    return answer

prices = [1,2,3,2,4]
print(solution(prices))

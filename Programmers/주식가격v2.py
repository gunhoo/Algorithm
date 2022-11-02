def solution(prices):
    answer = []
    mini = min(prices)

    for i in range(len(prices)):
        cnt = 0
        if prices[i] == mini:
            cnt = len(prices)-1-i
        else:
            for j in range(i+1, len(prices)):
                if prices[i] > prices[j]:
                    cnt = j-i
                    break
                else: cnt += 1
        answer.append(cnt)
    answer[-1] = 0

    return answer

prices = [1,2,3,2,4]
print(solution(prices))

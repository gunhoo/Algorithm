def solution(prices):
    answer = []
    for i in range(len(prices)):
        cnt = 0
        for j in range(i+1, len(prices)):
            if prices[i] > prices[j]:
                cnt += 1
                break
            else:
                cnt += 1
        answer.append(cnt)
    answer[-1] = 0
    return answer

prices = [1,2,3,2,4]
print(solution(prices))

def solution(n, left, right):
    answer = []

    # for i in range(n):
    #     if i*n <= right and i*n >= left-n:
    #         for j in range(n):
    #             if left <= i*n+j <= right:
    #                 answer.append(max(i, j)+1)

    for i in range(left, right+1):
        answer.append(max(i//n, i%n)+1)
    return(answer)
def solution(s):
    idx = 0
    answer = True
    for i in range(len(s)):
        if s[i] == "(":
            idx += 1
        else:
            idx -= 1
        if idx < 0:
            answer = False
            break
    if idx != 0:
        answer = False

    return answer

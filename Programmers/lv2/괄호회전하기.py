from collections import deque

def solution(s):
    answer = 0
    for j in range(len(s)):
        s = s[1:]+s[0]
        q = deque()
        for i in range(len(s)):
            if s[i] == "{" or s[i] =="(" or s[i] =="[":
                q.append(s[i])
            elif len(q) != 0:
                if s[i] == "]":
                    if len(q) != 0 and q[-1] == "[":
                        q.pop()
                elif s[i] == "}" :
                    if len(q) != 0 and q[-1] == "{":
                        q.pop()
                elif s[i] == ")" :
                    if len(q) != 0 and q[-1] == "(":
                        q.pop()
            else:
                q.append(s[i])
                break
        if len(q) == 0:
            answer += 1
    return answer
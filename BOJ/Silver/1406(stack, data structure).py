import sys
input = sys.stdin.readline

strings = list(map(str, input().strip()))
strings2 = []
for _ in range(int(input())):
    comm = list(input().split())
    if comm[0] == "P":
        strings.append(comm[1])
    elif comm[0] == "L":
        if strings:
            strings2.append(strings.pop())
    elif comm[0] == "D":
        if strings2:
            strings.append(strings2.pop())
    else:
        if strings:
            strings.pop()
strings2.reverse()
print("".join(strings), end = "")
print("".join(strings2))
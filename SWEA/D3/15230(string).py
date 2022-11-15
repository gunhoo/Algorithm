answer = "abcdefghijklmnopqrstuvwxyz"
for test_case in range(1, int(input())+1):
    output = 0
    alphabet = input()
    for i in range(len(alphabet)):
        if alphabet[i] == answer[i]:
            output += 1
        else:
            break
    print("#{} {}".format(test_case, output))
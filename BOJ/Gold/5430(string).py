import sys
input = sys.stdin.readline
from collections import deque

t = int(input())
for test_case in range(t):
    error_msg = False
    string = input().rstrip()
    array=deque()
    n = int(input())
    input_array = input().rstrip()
    if n!=0:
        for i in input_array[1:-1].split(','):
            array.append(i)
    idx = 0
    for i in range(len(string)):
        if string[i] == "R":
            # 아래 방법은 시간 초과의 원인
            # idx를 설정하고 나중에 reverse해줘도 돼
            #array.reverse()
            idx += 1
        # elif len(array) >0 and string[i] == "D" :
        #     array.popleft()
        elif len(array) == 0 and string[i] == "D" :
            error_msg = True
            break
        # idx가 홀수면 reverse한 상태이므로 뒤에서 뺴줌
        # 짝수면 reverse 결국 reverse안한 상태임으로 popleft
        else:
            if idx%2 != 0:
                array.pop()
            else:
                array.popleft()
    # 배열을 idx 대로 돌려놓기
    if idx %2 !=0:
        array.reverse()
    if error_msg == True:
        print("error")
    else:
        print("["+",".join(list(array))+"]")
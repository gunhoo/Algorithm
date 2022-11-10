import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(T):
    a, b = map(int, input().split())

    if a%10 == 1 or a%10==5 or a%10 == 6:
        ans = a%10
    elif a%10 == 2:
        arr = [2,4,8,6]
        ans = arr[(b%4)-1]
    elif a%10==3:
        arr = [3, 9, 7, 1]
        ans = arr[(b % 4)-1]
    elif a%10==4:
        arr = [4, 6]
        ans = arr[b%2-1]
    elif a%10 == 7:
        arr = [7, 9, 3, 1]
        ans = arr[(b % 4)-1]
    elif a%10 == 8:
        arr = [8, 4, 2, 6]
        ans = arr[(b % 4)-1]
    elif a%10 == 9:
        arr =  [9, 1]
        ans = arr[(b % 2)-1]
    else:
        ans = 10

    print(ans)
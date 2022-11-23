import sys
input = sys.stdin.readline

input_arr = input().strip()
while input_arr != "0":
    len_arr = len(input_arr)
    if input_arr == "0":
        exit(-1)
    if  len_arr % 2 == 0:
        if input_arr[:len_arr//2] == input_arr[:len_arr // 2-1:-1]:
            ans = "yes"
        else:
            ans = "no"
    else:
        if input_arr[:len_arr//2] == input_arr[:len_arr // 2:-1]:
            ans = "yes"
        else:
            ans = "no"
    print(ans)
    input_arr = input().strip()
# T = int(input())
#
# result_list = []
#
# for test_case in range(1, T + 1):
#     case = int(input())
#     list = []
#     for i in range(1, case+1):
#         list.append(str(i))
#     str = " ".join(list)
#     print(str)
#     str = str.replace("3", "-")
#     str = str.replace("6", "-")
#     str = str.replace("9", "-")
#     print(str)



case = int(input())
list = []
for i in range(1, case+1):
    flag, num = 0, 0
    save_num = i
    while (save_num!=0):
        r = save_num % 10
        if r%3 == 0 and r !=0 :
            flag = 1
            num += 1
        save_num = int(save_num/10)
    if flag == 0:
        list.append(i)
    else:
        list.append("-"*num)

print(" ".join(map(str, list)))

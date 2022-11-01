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

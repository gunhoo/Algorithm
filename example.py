# starbucks = ["아이언맨", "토르", "그루트"]
# for customer in starbucks:
#     print("{0}님, 커피준비됐씁니다.".format(customer))
#
# customer = "토르"
# index = 5
# while index >= 1:
#     print("{0}님, 커피가 준비됐습니다. {1}번 남았어요.".format(customer, index))
#     index -= 1
#     if index == 0:
#         print("커피는 폐끼됏ㅅ브니다.")
#
# absent = [2,5]
# no_book = [7]
# for student in range(1,11):
#     if student in absent:
#         continue
#     elif student in no_book:
#         print("오늘 수없 없어. {0}는 교무실로와 ".format(student))
#         break
# #     print("{0}야, 10쪽 읽어".format(student))
# from random import *
#
# indx=0
# for i in range(1, 51):
#     time = int(randrange(5,51))
#     if 5 <= time <= 15:
#         print("[o] {0}번째 손님 (소요시간 : {1}분)".format(i, time))
#         indx += 1
#         continue
#     else:
#         print("[ ] {0}번째 손님 (소요시간 : {1}분)".format(i, time))
#
# print("총 탑승 승객 : {0}".format(indx))
#
# def profile(name, age, *language):
#     print("이름 : {0}\t 나이 : {1}\t" \
#     .format(name, age), end=" ")
#     for lang in language:
#         print(lang, end="")
#     print()
#
# profile("김태호", 33, "JAVA", "Python", "c", "C++", "HTML")
# profile("김태호", 33, "JAVA", "Python")
# profile("김태호", 33, "JAVA", "Python", "c", "C++", "HTML", "Swift")

# #################
#
# gun  = 10
#
# def checkpoint(soldiers):
#     global gun
#     gun = gun - soldiers
#     print("[함수 내] 남은 총 : {0}".format(gun))
#
# def checkpoint_ret(gun, soldiers):
#     gun = gun - soldiers
#     print("[함수 내] 남은 총 : {0}".format(gun))
#     return gun
#
# print("전체 총 : {0}".format(gun))
# gun = checkpoint_ret(gun, 2)
# print("남은 총 : {0}".format(gun))

#
# def std_weight(height, gender):
#     weight = 0
#     if gender == "man":
#         weight = height*height*22
#     elif gender == "woman":
#         weight = height*height*21
#     else:
#         print("Please enter the right sex")
#     return weight
#
# height = 175
# gender = "man"
# weight = round(std_weight(height/100, gender), 2)
#
# print("키 {0}cm의 표준 체중은 {1}kg 입니다.".format(height, weight))

for i in range(10, -1, -1):
    print(i)

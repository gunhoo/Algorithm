T = int(input())
grades = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]

for test_case in range(1, T + 1):
    total, student = map(int, input().split())
    sum = [0]*total
    #sorted_sum = [0]*total

    for i in range(total):
        scores = list(map(int, input().split()))
        sum[i] = scores[0]*0.35+scores[1]*0.45+scores[2]*0.2
    score = sum[student-1]
    sum.sort(reverse=True)
    grade = sum.index(score) // (total//10)

    print("#{} {}".format(test_case, grades[grade]))

decode = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
          'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
          '0','1','2','3','4','5','6','7','8','9','+','/']

T = int(input())

for test_case in range(1, T+1):
    str = input()
    bin = ""
    new = []

    for c in str:
        bin += format(decode.index(c), 'b').zfill(6)
    print("#{}".format(test_case), end=" ")
    for i in range(len(str)*6//8):
        print(chr(int(bin[8*i:8*i+8], 2)), end="")
    print()

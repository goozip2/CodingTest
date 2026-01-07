import sys
input = sys.stdin.readline

T = int(input().strip())
arr = []
for t in range(T):
    result = 0
    conti = 1
    quiz = input().strip()
    for q in quiz:
        if(q=='X'):
            conti=1
        else:
            result += conti
            conti+=1
    print(result)
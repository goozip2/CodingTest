import sys
input = sys.stdin.readline

N = int(input().strip())
result = N
for i in range(N):
    word = input().strip()
    my_set = set()
    before = word[0]
    for c in word:
        if(c in my_set):
            if(c==before):
                continue
            else:
                result -= 1
                break
        else:
            my_set.add(c)
            before = c
print(result)
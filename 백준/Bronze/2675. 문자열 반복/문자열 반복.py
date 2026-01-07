import sys
input = sys.stdin.readline

T = int(input())
for t in range(T):
    R, S = input().strip().split()
    r = int(R)
    for s in S:
        print(s*r, end="")
    print()

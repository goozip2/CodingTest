import sys
input = sys.stdin.readline

N = int(input().strip())
arr = []
for n in range(N):
    arr.append(int(input().strip()))

arr.sort()
for n in range(N):
    print(arr[n])
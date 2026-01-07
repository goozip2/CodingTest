import sys
input = sys.stdin.readline

N = int(input().strip())
arr = list(map(int, input().strip().split()))

originalMax = max(arr)

for n in range(N):
    arr[n] = arr[n]/originalMax*100

newSum = sum(arr)
newAvg = newSum/N

print(newAvg)
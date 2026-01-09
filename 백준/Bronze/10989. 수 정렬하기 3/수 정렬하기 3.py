import sys
input = sys.stdin.readline

N = int(input().strip())
# index: 해당 숫자, value: 개수
arr = [0]*10001
for n in range(N):
    num = int(input().strip())
    arr[num]+=1 

for number, count in enumerate(arr):
    if count != 0:
        for i in range(count):
            print(number)

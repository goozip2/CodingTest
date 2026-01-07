import sys
input = sys.stdin.readline

arr = []
for i in range(9):
    arr.append(int(input().strip()))

max_num = max(arr)
max_index = arr.index(max_num)
print(max_num)
print(max_index+1)
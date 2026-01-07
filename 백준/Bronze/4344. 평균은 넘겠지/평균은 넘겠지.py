import sys
input = sys.stdin.readline

T = int(input().strip())
for t in range(T):
    arr = list(map(int, input().strip().split()))
    studentNum = arr[0]
    arr.pop(0)

    studentSum = sum(arr)
    studentAvg = studentSum/studentNum

    over = 0
    for score in arr:
        if (score> studentAvg):
            over+=1
    
    percent = over/studentNum*100
    print(round(percent,3),"%")
import sys, heapq
input = sys.stdin.readline

N = int(input().strip())

pq = []
for n in range(N):
    x,y = map(int, input().strip().split(" "))
    heapq.heappush(pq, (x,y))

for n in range(N):
    x,y = heapq.heappop(pq)
    print(x, y)
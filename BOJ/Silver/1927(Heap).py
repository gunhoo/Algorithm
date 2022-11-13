import sys
input = sys.stdin.readline
import heapq

heap = []
for _ in range(int(input())):
    x = int(input())
    if x == 0 and len(heap) == 0:
        print(0)
    elif x == 0 and len(heap) != 0:
        print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, x)
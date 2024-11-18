import heapq

class Solution:
    def maxEvents(self, events):
        events.sort() # sort by start time
        min_heap = []
        i, day, attended, n = 0, 0, 0, len(events)

        while i < n or min_heap:
            # Move to the next event's start day when there is no events in the heap
            if not min_heap:
                day = events[i][0]

            while i < n and events[i][0] <= day:
                heapq.heappush(min_heap, events[i][1])
                i += 1

            while min_heap and min_heap[0] < day:
                heapq.heappop(min_heap)

            if min_heap:
                heapq.heappop(min_heap)
                attended += 1
                day += 1
        return attended


class Solution:
    def minGroups(self, intervals: List[List[int]) -> int:
        minHeap = []
        sorted_intervals = sorted(intervals, key = lambda x: x[0])

        for start, end in sorted_intervals:
            if min_heap and min_heap[0] < start: //no overlap is allowed
                heappop(min_heap)
            heappush(min_heap, end)

        return len(min_heap)
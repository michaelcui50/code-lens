from heapq import heappop, heappush
from typing import List


class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        order = sorted(range(len(times)), key=lambda x: times[x][0])
        availableSeats, takenSeats = list(range(len(times))), []

        for i in order:
            ar, lv = times[i]
            while takenSeats and takenSeats[0][0] <= ar:
                heappush(availableSeats, heappop(takenSeats)[1])
            seat = heappop(availableSeats)
            if i == targetFriend: return seat
            heappush(takenSeats, (lv, seat))
        return -1
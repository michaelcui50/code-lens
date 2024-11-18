import java.util.*;

class Solution {
    fun maxEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] } // Sort by start day
        val minHeap = PriorityQueue<Int>()
        var day = 0, attended = 0, i = 0, n = events.size;

        while (i < n || minHeap.isNotEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0]
            }

            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            while (minHeap && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (minHeap) {
                minHeap.poll();
                day += 1;
                attended += 1;
            }
        }
        return attended;
    }
}
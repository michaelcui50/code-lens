import java.util.*;

class Solution {

    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0, day = 0, attendedMeetings = 0;

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0]; // Move to the next event's start day
            }
            // Add all events that start no later than current day
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]); // add end time to heap
                i++;
            }
            // Remove events that have already ended
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attendedMeetings++;
                day++;
            }
        }
        return attendedMeetings;
    }
}
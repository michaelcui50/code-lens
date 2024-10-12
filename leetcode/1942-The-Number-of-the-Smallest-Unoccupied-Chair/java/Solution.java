public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] orderedTimes = new int[n][2];
        for (int i = 0; i < n; i++) {
            orderedTimes[i] = times[i];
        }
        Arrays.sort(orderedTimes, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> emptySeats = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            emptySeats.offer(i);
        }

        PriorityQueue<int[]> occupiedSeats = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            int ar = orderedTimes[i][0];
            int lv = orderedTimes[i][1];
            while (!occupiedSeats.isEmpty() && occupiedSeats.peek()[0] <= ar) {
                emptySeats.offer(occupiedSeats.peek()[1]);
            }
            int seat = emptySeats.poll();
            occupiedSeats.offer(new int[]{lv, seat});
        }
        return -1;
    }
}
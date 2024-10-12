import java.util.PriorityQueue

class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val n = times.size
        val orderedTimes = times.copyOf().sortedWith(Comparator.comparingInt { it[0] })

        val emptySeats = PriorityQueue<Int> { a, b -> a - b }
        for (i in 0 until n) {
            emptySeats.add(i)
        }
        val takenSeats = PriorityQueue<IntArray>(Comparator.comparingInt { it[0] })

        for (i in 0 until n) {
            val (ar, lv) = times[i]
            while (takenSeats.isNotEmpty() && takenSeats.peek()[0] <= ar) {
                emptySeats.add(takenSeats.poll()[1])
            }
            val seat = emptySeats.poll()
            if (i == targetFriend) return seat
            takenSeats.offer(intArrayOf(lv, seat))
        }
        return -1
    }
}
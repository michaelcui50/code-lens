class Solution {
    fun minGroups(intervals: Array<IntArray>): Int {
        if (intervals == null) return 0
        return intervals
            .flatMap { (s, e) -> listOf(Pair(s, 1), Pair(e, -1))}
            .sortedWith( compareBy( {it.first}, {-it.second} ))
            .fold(Pair(0, 0)) { a, e -> Pair(max(a.first, a.second), a.second + e.second)}
            .first
    }
}
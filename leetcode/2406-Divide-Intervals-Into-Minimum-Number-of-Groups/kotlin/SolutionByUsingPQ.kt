fun minGroups(intervals: Array<IntArray>): Int {
    requireNotNull(intervals) { "intervals must be non-null" }
    intervals.sortWith( compareBy{ it[0] } )
    val pq = PriorityQueue<Int>()
    var groups = 1
    pq.add(intervals[0][1])
    for (i in 1..intervals.size-1) {
        val e = intervals[i]
        if (pq.peek() < e[0]) {
            pq.poll
        }else{
            groups++
        }
        pq.add(e[1])
    }
    return groups

}
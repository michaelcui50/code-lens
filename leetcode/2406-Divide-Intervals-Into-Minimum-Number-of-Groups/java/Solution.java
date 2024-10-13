public class Solution {
    public int minGroup(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        List<int[]> sortedEvents = new ArrayList<>();
        for (int[] itv : intervals) {
            sortedEvents.add(new int[]{itv[0], 1});
            sortedEvents.add(new int[]{itv[1], -1});
        }
        Collections.sort(sortedEvents, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });
        int groups = 0;
        int minGroups = 0;
        for (int[] e : sortedEvents) {
            groups += e[1];
            minGroups = Math.max(minGroups, groups);
        }
        return minGroups;

    }
}
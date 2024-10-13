class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        start_times = sorted(i[0] for i in intervals)
        end_times = sorted(i[1] for i in intervals)
        end_ptr, groups = 0, 0

        for start in start_times:
            # no overlap, so the group can be reused. no need to create a new group
            if start > end_times[end_ptr]:
                end_ptr += 1
            else:
                groups += 1
        return groups
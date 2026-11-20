class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        // 2. Loop through remaining intervals and merge if they overlap
        for (int[] next : intervals) {
            if (next[0] <= current[1]) {
                // Overlap found: extend the end time of the current interval
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap: move to the next interval and add it to the list
                current = next;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
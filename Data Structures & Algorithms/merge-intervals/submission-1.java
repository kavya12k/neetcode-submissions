class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        int lastEndIdx = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= output.get(lastEndIdx)[1]) {
                output.get(lastEndIdx)[1] = Math.max(output.get(lastEndIdx)[1], intervals[i][1]);
            } else {
                output.add(intervals[i]);
                lastEndIdx++;
            }
        }

        int[][] result = new int[output.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = output.get(i);
        }
        return result;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // n cars
        // i is position of the ith car
        // speed of ith car
        // destination is at target miles
        

        // car 1 is at 1 -> 4 -> 7 -> 10
        // car 2 is at 4 -> 6 -> 8 -> 10

        // car 1 is at 4 -> 6 -> 8 -> 10
        // car 2 is at 1 -> 3 -> 5 -> 7 -> 9 -> 10
        // car 3 is at 0 - 10
        // car 4 is at 7 -> 8 -> 9 -> 10

        int[][] pair = new int[position.length][2];
        for (int i = 0; i < pair.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<>();

        // [(7, 1), (4, 2), (1, 2), (0, 1)]
        // [3, 3, 4.5, 10]

        // (1, 3), (4, 2)
        // [(4, 2), (1, 3)]
        // 3, 3

        for (int[] p : pair) {
            double time = ((double)(target) - p[0]) / p[1];
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }
            stack.push(time);
        }
        return stack.size();

    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int val = maxHeap.poll();
                if (val > 1) {
                    queue.add(new int[]{val - 1, time + n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.remove()[0]);
            }
        }
        return time;
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int top1 = maxHeap.poll();
            int top2 = maxHeap.poll();
            if (top1 < top2) {
                maxHeap.offer(top2 - top1);
            } else if (top1 > top2) {
                maxHeap.offer(top1 - top2);
            }
        }

        if (maxHeap.size() == 0) {
            return 0;
        } else {
            return maxHeap.peek();
        }
        
    }
}

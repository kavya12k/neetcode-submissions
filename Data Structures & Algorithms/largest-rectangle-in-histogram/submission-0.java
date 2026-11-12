class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque <Integer> stack = new ArrayDeque<>();
        
        int currBest = 0;

        // 7 1 7 6 2 4
        // 1 1 6 2 2 4 

        // 0
        // 7
        // 

        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] <= heights[stack.peek()])) {
                int h = heights[stack.pop()];
                int w = 0;
                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - stack.peek() - 1;
                }
                currBest = Math.max(currBest, h * w);
            }

            stack.push(i);
        }
        
        return currBest;
    }
}

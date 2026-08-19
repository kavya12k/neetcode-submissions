class Solution {
    public int trap(int[] height) {
        int [] maxLeft = new int[height.length];
        int [] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];

        for (int left = 1; left < height.length; left++) {
            int right = height.length - 1 - left;
            maxLeft[left] = Math.max(maxLeft[left - 1], height[left]);
            maxRight[right] = Math.max(maxRight[right + 1], height[right]);
        }

        int total = 0;

        for (int i = 0; i < height.length; i++) {
            total += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return total;
        
    }
}
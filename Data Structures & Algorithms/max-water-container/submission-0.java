class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = (Math.min(height[left], height[right]) * (right - left));
        while (left < right) {
            if (height[left] < height[right]) {
               left += 1;
            } else {
                right -= 1;
            }
            max = Math.max(max, (Math.min(height[left], height[right]) * (right - left)));
        } 
        return max;      
    }
}
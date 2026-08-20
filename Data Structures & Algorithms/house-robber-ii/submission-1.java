class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);        
        }
        int[] dpOne = new int[nums.length];
        int[] dpTwo = new int[nums.length];

        dpOne[0] = nums[0];
        dpOne[1] = Math.max(nums[0], nums[1]);
        dpTwo[0] = 0;
        dpTwo[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dpOne[i] = Math.max(dpOne[i - 1], dpOne[i - 2] + nums[i]);
            dpTwo[i] = Math.max(dpTwo[i - 1], dpTwo[i - 2] + nums[i]);
        }

        return Math.max(dpOne[nums.length - 2], dpTwo[nums.length - 1]);
        
    }
}

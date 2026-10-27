class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int[] dpOne = new int[nums.length];
        dpOne[0] = nums[0];
        dpOne[1] = Math.max(nums[0], nums[1]);


        int[] dpTwo = new int[nums.length];
        dpTwo[0] = 0;
        dpTwo[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dpOne[i] = Math.max(dpOne[i - 2] + nums[i], dpOne[i - 1]);
            dpTwo[i] = Math.max(dpTwo[i - 2] + nums[i], dpTwo[i - 1]);
        }

        return Math.max(dpOne[nums.length - 2], dpTwo[nums.length - 1]);
        
    }
}

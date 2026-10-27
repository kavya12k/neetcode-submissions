class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            sum = Math.max(currSum, sum);
        }
        return sum;
    }
}

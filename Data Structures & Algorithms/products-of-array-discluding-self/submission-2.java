class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefArray = new int[nums.length];
        int[] suffArray = new int[nums.length];
        int[] output = new int[nums.length];
        prefArray[0] = nums[0];
        suffArray[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefArray[i] = prefArray[i - 1] * nums[i];
            suffArray[nums.length - 1 - i] = suffArray[nums.length - i] * nums[nums.length - 1 - i];
        }
        output[0] = suffArray[1];
        output[nums.length - 1] = prefArray[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            output[i] = prefArray[i - 1] * suffArray[i + 1];
        }
        return output;
    }
}  

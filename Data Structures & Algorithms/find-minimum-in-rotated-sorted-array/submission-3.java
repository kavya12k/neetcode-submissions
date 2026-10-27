class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                if (mid > 0 && nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }
                high = mid - 1;
            } else {
                break;
            }
        }

        return nums[mid];
    }
}

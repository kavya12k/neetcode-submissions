class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = nums.length - 1; i >= 0; i--) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i]) && hm.get(target-nums[i]) != i) {
                if (i < hm.get(target-nums[i])) {
                    result[0] = i;
                    result[1] = hm.get(target-nums[i]);
                } else {
                    result[1] = i;
                    result[0] = hm.get(target-nums[i]);
                }
                
                return result;
            }
        }
        return result;
        
    }
}

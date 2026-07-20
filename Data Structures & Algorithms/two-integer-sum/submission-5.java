class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                if (i < map.get(diff)) {
                    result[0] = i;
                    result[1] = map.get(diff);
                } else {
                    result[0] = map.get(diff);
                    result[1] = i;
                }
                return result;
            }
        }
        return result;
        
    }
}

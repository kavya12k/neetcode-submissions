class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        if (nums.length > set.size()) {
            return true;
        }
        return false;
    }
}
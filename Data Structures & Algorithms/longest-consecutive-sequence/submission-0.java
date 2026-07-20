class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> vals = new HashSet<Integer>();
        for (Integer n : nums) {
            vals.add(n);
        }
        int streak = 0;
        for (Integer v : vals) {
            if (!vals.contains(v - 1)) {
                int currStreak = 1;
                while (vals.contains(v + currStreak)) {
                    currStreak += 1;
                }
                if (currStreak > streak) {
                streak = currStreak;
                }   
            } 
        }
        return streak;
    }
}

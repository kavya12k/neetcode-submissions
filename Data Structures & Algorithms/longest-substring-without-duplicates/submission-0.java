class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        int right = 0;

        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1); //start off w nothing

        for (right = 0; right < s.length(); right++) {
            left = Math.max(left, charIndex[s.charAt(right)] + 1);
            charIndex[s.charAt(right)] = right;
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
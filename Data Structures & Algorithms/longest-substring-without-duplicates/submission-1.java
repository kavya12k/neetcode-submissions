class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> setChars = new HashMap<Character, Integer>();
        if (s.length() < 2) {
            return s.length();
        }

        int left = 0;
        int currMax = 1;
        setChars.put(s.charAt(left), 1);

        for (int right = 1; right < s.length(); right++) {
            while (setChars.getOrDefault(s.charAt(right), 0) > 0) {
                setChars.put(s.charAt(left), setChars.get(s.charAt(left)) - 1);
                left++;
            }
            setChars.put(s.charAt(right), 1);
            currMax = Math.max(currMax, right - left + 1);
        }

        return currMax;

        
    }
}

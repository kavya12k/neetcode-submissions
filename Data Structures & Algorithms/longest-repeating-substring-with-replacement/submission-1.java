class Solution {
    public int characterReplacement(String s, int k) {
        if (k >= s.length() - 1) {
            return s.length();
        }

        int maxFreq = 0;
        int left = 0;
        int result = 0;
        Map <Character, Integer> cToF = new HashMap<Character, Integer>();
        for (int right = 0; right < s.length(); right++) {
            cToF.put(s.charAt(right), cToF.getOrDefault(s.charAt(right), 0)+ 1);
            // start w placing character in map
            maxFreq = Math.max(maxFreq, cToF.get(s.charAt(right)));
            while (right - left + 1 - maxFreq > k) {
                cToF.put(s.charAt(left), cToF.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}

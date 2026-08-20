class Solution {
    public int characterReplacement(String s, int k) {
        if (k >= s.length() - 1) {
            return s.length();
        }
        int max = 0;
        int maxFreq = 0;
        int left = 0;
        int result = 0;
        Map <Character, Integer> charToFreq = new HashMap<Character, Integer>();
        for (int right = 0; right < s.length(); right++) {
            charToFreq.put(s.charAt(right), charToFreq.getOrDefault(s.charAt(right), 0) + 1);
            if (charToFreq.get(s.charAt(right)) > maxFreq) {
                maxFreq = charToFreq.get(s.charAt(right));
            }
            while ((right - left + 1) - maxFreq > k) {
                charToFreq.put(s.charAt(left), charToFreq.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);        
        }
        return result;

        
        
    }
}

class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            // odd case:
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > result.length()) {
                result = s.substring(left + 1, right);
            }

            //even case:
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > result.length()) {
                result = s.substring(left + 1, right);
            }
        }
        return result;
       
        
    }
}
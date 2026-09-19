class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tFreq = new HashMap<Character, Integer>();

        for (Character c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int numChars = tFreq.size();
        int charsInS = 0;

        Map<Character, Integer> sFreq = new HashMap<Character, Integer>();

        int currMin = Integer.MAX_VALUE;
        int lRes = -1;
        int rRes = -1;

        int left = 0;
        int right = 0;


        for (right = 0; right < s.length(); right++) {
            sFreq.put(s.charAt(right), sFreq.getOrDefault(s.charAt(right), 0) + 1);
            if (tFreq.containsKey(s.charAt(right)) && sFreq.get(s.charAt(right)).equals(tFreq.get(s.charAt(right)))) {
                charsInS++;
            }
            

            while(charsInS == numChars) {
                if(right - left + 1 < currMin) {
                    currMin = right - left + 1;
                    lRes = left;
                    rRes = right;
                }
                sFreq.put(s.charAt(left), sFreq.get(s.charAt(left)) - 1);
                if (tFreq.containsKey(s.charAt(left)) && sFreq.get(s.charAt(left)) < tFreq.get(s.charAt(left))) {
                    charsInS--;
                }
                left++;
            }
        }

        if (lRes < 0 || rRes < 0) {
            return "";
        }
        return s.substring(lRes, rRes + 1);
        
    }
}

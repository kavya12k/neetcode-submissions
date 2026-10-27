class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        } else if (s.equals(t)) {
            return s;
        }

        Map<Character, Integer> tFreq = new HashMap<Character, Integer>();
        for (Character c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        int numChars = tFreq.size();
        int charsInS = 0;
        // we want charsInS = numChars

        Map<Character, Integer> sFreq = new HashMap<Character, Integer>();
        int min = Integer.MAX_VALUE;
        int leftIndexResult = -1;
        int rightIndexResult = -1;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            sFreq.put(s.charAt(right), sFreq.getOrDefault(s.charAt(right), 0) + 1);
            if (tFreq.containsKey(s.charAt(right)) && tFreq.get(s.charAt(right)).equals(sFreq.get(s.charAt(right)))) {
                charsInS++;
            }
            while (numChars == charsInS) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    leftIndexResult = left;
                    rightIndexResult = right;
                }
                sFreq.put(s.charAt(left), sFreq.get(s.charAt(left)) - 1);
                if (tFreq.containsKey(s.charAt(left)) && tFreq.get(s.charAt(left)) > sFreq.get(s.charAt(left))) {
                charsInS--;
                }
                left++;
            }
        }

        if (leftIndexResult < 0 || rightIndexResult < 0) {
            return "";
        }
        return s.substring(leftIndexResult, rightIndexResult + 1);
        



        
    }
}

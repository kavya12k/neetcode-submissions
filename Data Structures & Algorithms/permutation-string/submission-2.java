class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        Arrays.fill(s1Map, 0);
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 97]++;
        }
        int[] s2Map = new int[26];
        Arrays.fill(s2Map, 0);

        int left = 0; 
        int right = 0; 
        for (right = 0; right < s1.length(); right++) {
            s2Map[s2.charAt(right) - 97]++;
        }

        if (Arrays.equals(s1Map, s2Map)) {
            return true;
        }

        for (right = right; right < s2.length(); right++) {
            s2Map[s2.charAt(right) - 97]++;
            s2Map[s2.charAt(left) - 97]--;
            left++;
            if (Arrays.equals(s1Map, s2Map)) {
                return true;
            }
        }

        return false;
        
    }
}

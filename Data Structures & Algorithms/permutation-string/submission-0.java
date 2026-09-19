class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] perm = new int[26];
        Arrays.fill(perm, 0);

        for (Character c : s1.toCharArray()) {
            perm[(int)c - 97]++;
        }

        int[] container = new int[26];
        Arrays.fill(container, 0);

        int right = 0;

        for (right = 0; right < s1.length(); right++) {
            container[(int)(s2.charAt(right)) - 97]++;
        }

        if (Arrays.equals(container, perm)) {
            return true;
        }

        for (int left = 0; left < s2.length() - s1.length(); left++) {
            container[(int)(s2.charAt(left)) - 97]--;
            container[(int)(s2.charAt(right)) - 97]++;
            right++;

             if (Arrays.equals(container, perm)) {
                return true;
            }
        }

        return false;


        
    }
}

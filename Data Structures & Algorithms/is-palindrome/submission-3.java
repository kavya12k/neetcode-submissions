class Solution {
    public boolean isPalindrome(String s) {
        String valsOnly = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char [] sArray = valsOnly.toCharArray();
        if (sArray.length == 0) {
            return true;
        }
        for (int i = 0; i < sArray.length / 2 + 1; i++) {
            if (sArray[i] != sArray[sArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
        
    }
}

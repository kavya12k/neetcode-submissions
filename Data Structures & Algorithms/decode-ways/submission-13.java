class Solution {
    public int numDecodings(String s) {
        long[] dp = new long[s.length()];

        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        dp[0] = 1;
        if (s.charAt(1) == '0' && (s.charAt(0) != '1' && s.charAt(0) != '2')) {
            return 0;
        }

        if ((s.charAt(0) == '1' && s.charAt(1) != '0') || (s.charAt(0) == '2' && 
        (s.charAt(1) == '1' || s.charAt(1) == '2' || s.charAt(1) == '3' 
        || s.charAt(1) == '4' || s.charAt(1) == '5' || s.charAt(1) == '6'))) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')) {
                return 0;
            }
            if (s.charAt(i) == '0') {
                dp[i] = dp[i - 2];
            }
            else if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                dp[i] = dp[i - 1];
            } else {
                if (s.charAt(i - 1) == '2' && s.charAt(i) != '1' && s.charAt(i) != '2' && s.charAt(i) != '3' && s.charAt(i) != '4' && s.charAt(i) != '5' && s.charAt(i) != '6') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return (int)dp[s.length() - 1];
        
    }
}

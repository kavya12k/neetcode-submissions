class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > high) {
                high = piles[i];
            }
        }

        int low = 1;

        int currSpeed = high;
        // low = 1, high = 4, mid = 2

        // numHours = 1 + 2 + 2 + 1 = 6
        // high = 1
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("currSpeed: " + currSpeed);
            System.out.println("high: " + high);
            System.out.println("mid: " + mid);
            System.out.println("low: " + low);
            double numHours = 0.0;
            for (Integer banan : piles) {
                numHours += Math.ceil((double)banan / mid);
            }
            if (numHours <= h) {
                if (mid < currSpeed) {
                    currSpeed = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return currSpeed;
    }
}

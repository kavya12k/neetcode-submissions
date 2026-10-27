class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rLow = 0;
        int rHigh = matrix.length - 1;
        int rMid = 0;

        while (rLow <= rHigh) {
            rMid = rLow + (rHigh - rLow) / 2;
            System.out.println(rMid);
            if (target == matrix[rMid][0]) {
                return true;
            } else if (target < matrix[rMid][0]) {
                rHigh = rMid - 1;
            } else {
                if ((rMid < matrix.length - 1) && 
                        target < matrix[rMid + 1][0]) {
                    break;
                }
                rLow = rMid + 1;
            }
        }


        int cLow = 0;
        int cHigh = matrix[0].length - 1;
        while (cLow <= cHigh) {
            int cMid = cLow + (cHigh - cLow) / 2;
            if (target == matrix[rMid][cMid]) {
                return true;
            } else if (target > matrix[rMid][cMid]) {
                cLow = cMid + 1;
            } else {
                cHigh = cMid - 1;
            }
        }

        return false;
        
    }
}

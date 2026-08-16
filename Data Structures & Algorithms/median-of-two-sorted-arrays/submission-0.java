class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int start = 0;
        int end = nums1.length; 
        int totalHalf = (nums1.length + nums2.length + 1) / 2;

        

        while (start <= end) {
            int partition_i = (start + end) / 2;
            int partition_j = totalHalf - partition_i;

            int l1;
            if (partition_i == 0) {
                l1 = Integer.MIN_VALUE;
            } else {
                l1 = nums1[partition_i - 1];
            }

            int l2;
            if (partition_j == 0) {
                l2 = Integer.MIN_VALUE;
            } else {
                l2 = nums2[partition_j - 1];
            }

            int r1;
            if (partition_i == nums1.length) {
                r1 = Integer.MAX_VALUE;
            } else {
                r1 = nums1[partition_i];
            }

            int r2;
            if (partition_j == nums2.length) {
                r2 = Integer.MAX_VALUE;
            } else {
                r2 = nums2[partition_j];
            }

            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return ((double)(Math.max(l1, l2)) + (double)(Math.min(r1, r2))) / 2;
                } else {
                    return ((double)(Math.max(l1, l2)));
                }
            } else if (l2 > r1) {
                start = partition_i + 1;
            } else {
                end = partition_i - 1;
            }

        }
        return -1.0;
        
    }
}
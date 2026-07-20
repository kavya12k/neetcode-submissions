class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] solution = new int[k];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // maps each number to a frequency 


        List<Integer>[] freqToNums = new List[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            freqToNums[i] = new ArrayList<>();
        }

        for (Integer key : freqMap.keySet()) {
            freqToNums[freqMap.get(key)].add(key);
        }

        int indexSol = 0;
        for (int i = nums.length; i >= 1; i--) {
            for (int val : freqToNums[i]) {
                solution[indexSol] = val;
                indexSol++;
                if (indexSol == k) {
                    return solution;
                }
            }
        }
        return solution;
        
    }
}

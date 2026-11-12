class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new ArrayDeque<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int pop = nums.removeFirst();
                pop += nums.removeFirst();
                nums.addFirst(pop);
            } else if (tokens[i].equals("*")) {
                int pop = nums.removeFirst();
                pop *= nums.removeFirst();
                nums.addFirst(pop);
            } else if (tokens[i].equals("-")) {
                int pop1 = nums.removeFirst();
                int pop2 = nums.removeFirst() - pop1;
                nums.addFirst(pop2);
            } else if (tokens[i].equals("/")) {
                int pop1 = nums.removeFirst();
                int pop2 = nums.removeFirst() / pop1;
                nums.addFirst(pop2);
            } else {
                nums.addFirst(Integer.valueOf(tokens[i]));
            }

        }
        return nums.peekFirst();
        
    }
}

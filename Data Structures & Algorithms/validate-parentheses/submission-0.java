class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();

        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> stack = new ArrayDeque<Character>();

        for (Character c : s.toCharArray()) {
            if (map.values().contains(c)) {
                stack.addFirst(c);
            } else {
                if (map.get(c) == stack.peekFirst()) {
                    stack.removeFirst();
                } else {
                    return false;
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        }
        return true;
        
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> charsToAnagrams = new HashMap<>();
        // maps the sorted characters of a string to its associated anagrams
        for (String s : strs) {
            char[] sortedChars = s.toCharArray();
            Arrays.sort(sortedChars);
            String sortedStr = new String(sortedChars);
            if (charsToAnagrams.containsKey(sortedStr)) {
                charsToAnagrams.get(sortedStr).add(s);
            } else {
                List <String> ls = new ArrayList<>();
                ls.add(s);
                charsToAnagrams.put(sortedStr, ls);
            }
        }
        return new ArrayList<>(charsToAnagrams.values());
    }
}

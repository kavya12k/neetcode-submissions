class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<HashMap<Character, Integer>, List<String>> hm = new HashMap<HashMap<Character, Integer>, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> charMap = getCharMap(strs[i]);
            if(hm.containsKey(charMap)) {
                hm.get(charMap).add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                hm.put(charMap, list);
            }
        }
        for(HashMap<Character,Integer> key : hm.keySet()) {
            result.add(hm.get(key));
        }
        return result;
    }

    public HashMap<Character, Integer> getCharMap(String str) {
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        return charMap;
    }
}

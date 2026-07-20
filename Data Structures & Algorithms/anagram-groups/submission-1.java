class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<List<String>>();

        // base case of only one thing
        if (strs.length == 1) {
            List<String> value = new ArrayList<String>();
            value.add(strs[0]);
            solution.add(value);
            return solution;
        }

        // extra cases, create map
        List<HashMap<Character, Integer>> maps = new ArrayList<HashMap<Character, Integer>>();

        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> map = strToMap(strs[i]);
            maps.add(map);
        }

        for (int j = 0; j < strs.length; j++) {
            if (strs[j] != "0") {
                List<String> anagramSet = new ArrayList<String>();
                anagramSet.add(strs[j]);
                for (int k = j + 1; k < strs.length; k++) {
                    if (maps.get(j).equals(maps.get(k))) {
                        anagramSet.add(strs[k]);
                        strs[k] = "0";
                    }
                }
                solution.add(anagramSet);
            }
        }
        return solution;
        
    }

    public HashMap<Character, Integer> strToMap(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}

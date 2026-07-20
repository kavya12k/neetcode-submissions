class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length());
            encoded.append('#');
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find the '#' separating the length from the string
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // Parse the length
            int length = Integer.parseInt(str.substring(i, j));

            // Extract the string
            String word = str.substring(j + 1, j + 1 + length);
            result.add(word);

            // Move to the next encoded string
            i = j + 1 + length;
        }

        return result;
    }
}

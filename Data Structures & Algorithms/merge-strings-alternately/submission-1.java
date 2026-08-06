class Solution {
    public String mergeAlternately(String word1, String word2) {
        int f1 = 0;
        int f2 = 0;
        StringBuilder sb = new StringBuilder("");

        for (int i=0; i<Math.min(word1.length(), word2.length()); i++) {
            sb.append(word1.charAt(f1));
            sb.append(word2.charAt(f2));
            f1++;
            f2++;
        }

        if (word1.length() > word2.length()) {
            for (int i = f1; i<word1.length(); i++) {
                sb.append(word1.charAt(f1));
                f1++;
            }
        } else {
            for (int i = f2; i<word2.length(); i++) {
                sb.append(word2.charAt(f2));
                f2++;
            }
        }

        return sb.toString();
    }
}
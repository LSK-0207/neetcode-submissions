class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int f1 = 0;
        int f2 = 0;
        StringBuilder sb = new StringBuilder("");

        while (f1<w1 && f2<w2) {
            sb.append(word1.charAt(f1));
            sb.append(word2.charAt(f2));
            f1++;
            f2++;
        }

        while (f1 < w1) {
            sb.append(word1.charAt(f1));
            f1++;
        }

        while (f2<w2){
            sb.append(word2.charAt(f2));
            f2++;
        }

        return sb.toString();
    }
}
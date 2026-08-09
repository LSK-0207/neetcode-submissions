class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r< s.length(); r++){
            char c = s.charAt(r);
            if(map.containsKey(c) && l<=map.get(c)){
                l=map.get(c)+1;
            }

            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}

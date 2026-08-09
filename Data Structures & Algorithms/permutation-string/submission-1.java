class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int[] s1Notepad= new int[26];
        int[] windowNotepad = new int[26];

        for (int i=0; i<s1.length(); i++){
            s1Notepad[s1.charAt(i)-'a']++;
            windowNotepad[s2.charAt(i)-'a']++;
        }

        for (int right = s1.length(); right < s2.length(); right++){
            if(Arrays.equals(s1Notepad, windowNotepad)) return true;

            windowNotepad[s2.charAt(right)-'a']++;

            int left = right - s1.length();
            windowNotepad[s2.charAt(left)-'a']--;
        }

        return Arrays.equals(s1Notepad, windowNotepad);
    }
}

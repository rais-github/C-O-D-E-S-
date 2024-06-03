class Solution {
    public int appendCharacters(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int sptr = 0, tptr = 0;

        while (sptr < n1 && tptr < n2) {
            if (s.charAt(sptr) == t.charAt(tptr)) {
                tptr++;
            }
            sptr++;
        }

        return n2 - tptr;
    }
}

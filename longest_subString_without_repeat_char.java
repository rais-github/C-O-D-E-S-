import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                max = Math.max(sb.length(), max);
                while (sb.charAt(0) != c) {
                    set.remove(sb.charAt(0));
                    sb.deleteCharAt(0);
                }
                sb.deleteCharAt(0);
            }
            sb.append(c);
            set.add(c);
        }
        
        return Math.max(sb.length(), max);
    }
}

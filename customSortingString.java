class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int maxIdx = Integer.MIN_VALUE;
        int count[] = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int idx = (int) (s.charAt(i) - 'a');
            count[idx]++;
            maxIdx = Math.max(maxIdx, idx);
        }
        
        for (int i = 0; i < order.length(); i++) {
            int idx = (int) (order.charAt(i) - 'a');
            while (count[idx] > 0) {
                sb.append((char) (idx + 'a'));
                count[idx]--;
            }
        }
        
        for (int i = 0; i <= maxIdx; i++) {
            while (count[i] > 0) {
                sb.append((char) (i + 'a'));
                count[i]--;
            }
        }
        
        return sb.toString();
    }
}

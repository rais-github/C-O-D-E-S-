  class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';  
                freq[idx]++;
                int max = (int)1e-9;
                int min = (int)1e9;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] >= 1) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }
                sum = sum + (max - min);
            }
        }
        return sum;
    }
}

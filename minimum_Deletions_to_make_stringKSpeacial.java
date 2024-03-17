class Solution {
    public int minimumDeletions(String word, int k) {
         HashMap<Character,Integer> charCount = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (charCount.containsKey(character)) {
                charCount.put(character, charCount.get(character) + 1);
            } else {
                charCount.put(character, 1);
            }
        }
        
        ArrayList<Integer> frequencies = new ArrayList<>();
        for (int freq : charCount.values()) {
            frequencies.add(freq);
        }
        
        frequencies.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        int minDeletions = Integer.MAX_VALUE;
        
        for (int i = 0; i < frequencies.size(); i++) {
            int targetFreq = frequencies.get(i);
            int deletions = 0;
            
            for (int freq : frequencies) {
                if (freq > targetFreq + k) {
                    deletions += freq - (targetFreq + k);
                } else if (freq < targetFreq) {
                    deletions += freq;
                }
            }
            
            minDeletions = Math.min(minDeletions, deletions);
            if (minDeletions == 0) {
                break;
            }
        }
        
        return minDeletions != Integer.MAX_VALUE ? minDeletions : 0;
    }
}

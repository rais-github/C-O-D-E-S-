class Solution {
    public int minimumPushes(String word) {
    int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Integer> freqList = new ArrayList<>();
        for (int count : freq) {
            if (count > 0) {
                freqList.add(count);
            }
        }

        
        Collections.sort(freqList, Collections.reverseOrder());

        int result = 0;
        int keyPress = 1; 

        for (int i = 0; i < freqList.size(); i++) {
            result += freqList.get(i) * keyPress;
            if ((i + 1) % 8 == 0) {
                keyPress++;
            }
        }

        return result;
    }
}

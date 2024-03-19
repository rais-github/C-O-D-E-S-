class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 1)
            return 1;
        if (n == 0) return tasks.length;
        int[] taskFrequency = new int[26];
        int maxFreq = 0, maxFreqCount = 0, taskCount = tasks.length;
        
        for (char task : tasks) {
            taskFrequency[task - 'A']++; 
            if (taskFrequency[task - 'A'] > maxFreq) {
                maxFreq = taskFrequency[task - 'A']; 
            }
        }

        for (int i = 0; i < 26; i++) {
            if (taskFrequency[i] == maxFreq) 
                maxFreqCount++; 
        }

        int totalTime = (maxFreq - 1) * (n + 1) + maxFreqCount; 
        return Math.max(totalTime, taskCount);
    }
}

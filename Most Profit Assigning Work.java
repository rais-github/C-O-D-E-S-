

class Pair {
    int difficulty, profit;
    public Pair(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int m = worker.length;
        ArrayList<Pair> list = new ArrayList<>();
        
        // Create the list of pairs
        for (int i = 0; i < n; i++) {
            list.add(new Pair(difficulty[i], profit[i]));
        }
        
        // Sort the list by difficulty
        Collections.sort(list, (a, b) -> a.difficulty - b.difficulty);
        
        // Sort the worker array
        Arrays.sort(worker);
        
        // Create an array to store the max profit for each difficulty level
        int[] maxProfitForDifficulty = new int[n];
        maxProfitForDifficulty[0] = list.get(0).profit;
        
        // Fill the maxProfitForDifficulty array
        for (int i = 1; i < n; i++) {
            maxProfitForDifficulty[i] = Math.max(maxProfitForDifficulty[i - 1], list.get(i).profit);
        }
        
        int sum = 0;
        
        // Iterate through each worker
        for (int w : worker) {
            sum += search(list, maxProfitForDifficulty, w);
        }
        
        return sum;
    }
    
    private int search(ArrayList<Pair> list, int[] maxProfitForDifficulty, int ability) {
        int low = 0, high = list.size() - 1;
        
        // Binary search to find the maximum difficulty <= worker's ability
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).difficulty <= ability) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        // If high is -1, it means no difficulty is less than or equal to ability
        return high == -1 ? 0 : maxProfitForDifficulty[high];
    }
}

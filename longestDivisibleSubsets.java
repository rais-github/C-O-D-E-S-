    class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        List<Integer> lis = new ArrayList<>();
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIdx = -1;
        int maxi = -(int)1e9;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            dp[i] = 1; 
            hash[i] = i; 
        }

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] % arr[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIdx = i;
            }
        }

        while (hash[lastIdx] != lastIdx) {
            lis.add(arr[lastIdx]);
            lastIdx = hash[lastIdx];
        }
        lis.add(arr[lastIdx]); 

        Collections.reverse(lis);

        return lis;
    }
}


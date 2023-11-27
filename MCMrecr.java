class MCMrecr {
    public static int matrixMultiplication(int N, int arr[]) {
        int minAns = Integer.MAX_VALUE;
        return solve(arr, 1, N - 1, minAns);
    }

    private static int solve(int[] ar, int i, int j, int minAns) {
        if (i >= j) return 0;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(ar, i, k, minAns) + solve(ar, k + 1, j, minAns) + ar[i - 1] * ar[k] * ar[j];
            minAns = Math.min(minAns, temp);
        }
        return minAns;
    }
}
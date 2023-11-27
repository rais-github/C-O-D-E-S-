import java.util.Arrays;
public class matMultiplcation_Memo {
    public static int matrixMultiplication(int N, int arr[]) {
        int t[][] = new int[101][101];
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(arr, 1, N - 1, t);
    }

    private static int solve(int[] ar, int i, int j, int[][] t) {
        if (i >= j) return 0;
        if (t[i][j] != -1) return t[i][j];

        int minAns = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(ar, i, k, t) + solve(ar, k + 1, j, t) + ar[i - 1] * ar[k] * ar[j];
            minAns = Math.min(minAns, temp);
        }

        t[i][j] = minAns;
        return minAns;
    }
}


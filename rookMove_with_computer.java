import java.util.Scanner;

public class C_How_Does_the_Rook_Move {
    public static void main(String[] args) {
        final int MOD = 100_000_0007; 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] dp = new long[n+1];
            // handle edge cases
            dp[0] = 0; // no valid config for zero sized baord
            dp[1] = 1; // 1 for 1 sized board
            dp[2] = 3; // 3 ways for 2 size board
            
            // compute for remaining baord or we can say board greater than size 2
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + (dp[i - 2] * (2L * (i - 1) % MOD) % MOD)) % MOD; 
            }
            int x = 0, y = 0, left = n;
            for (int i = 0; i < k; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                if (x == y) left = left - 1;// if kept at diagonal we have n-1 * n-1 board remaining
                else left = left - 2;  // if we kept at non-diagoanl we have n-2*n-2 board remaining
            }
            if (k == n) {
                System.out.println(0);
                // as this is the maximum rooks we can place, by placing diagonally
            } else {
                System.out.println(dp[left]); // return the computations for the left or remaining 
            }
        }
        sc.close();
    }
}

class Solution {
    private final static int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        if (n == 1) return 5;
        long even = (n + 1) / 2;  
        long odd = n / 2;         
        
        // Calculate (5^even) % MOD and (4^odd) % MOD
        long result = (pow(5, even) * pow(4, odd)) % MOD;
        return (int) result;
    }


    private long pow(long base, long exp) {
        if (exp == 0) return 1;  
        
        long half = pow(base, exp / 2);
        half = (half * half) % MOD;  
        
        if (exp % 2 != 0) { 
            half = (half * base) % MOD;
        }
        
        return half;
    }
}

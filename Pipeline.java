import java.util.Scanner;

class B_Pipeline {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        long n = inp.nextLong();
        long k = inp.nextLong();
        
        if (n == 1) {
            System.out.println(0);
        } 
        else if (k * (k + 1) / 2 < n) {
            System.out.println(-1);
        } 
        else {
            n--; 
            k--;
            long low = 1, high = k;
            long ans = -1;

            while (low <= high) {
                long mid = (low + high) / 2;
                long sum = k * (k + 1) / 2 - (mid * (mid + 1) / 2) + mid;

                if (sum == n) {
                    ans = k - mid + 1;
                    break;
                } 
                else if (sum > n) {
                    low = mid + 1;
                    ans = k - mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
            System.out.println(ans);
        }

        inp.close();
    }
}

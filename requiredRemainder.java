import java.util.Scanner;

public class A_Required_Remainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long n = sc.nextLong();

            // we can say that k = x * q + y -> here q and k both are missing
            // we know k <= n 
            // x*q + y <= n
            // q <= (n-y)/x -> find q from here and put in the equation k = x*q + y
            // k = x * ((n-y)/x) + y
            // k = n - (n-y)%x

            System.out.println(n - (n-y)%x);
        }
        sc.close();
    }
}

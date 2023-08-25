import java.util.Scanner;

public class recr_josephus {
    public static int jos(int n , int k){
        if(n==1) return 0;
        else return ((jos((n-1),k))+k)%n;
    }
     public static int Josephus(int N, int k) {
 
    // Initialize variables i and ans with 1 and 0 respectively.
    int i = 1, ans = 0;
 
    // Run a while loop till i <= N
    while (i <= N) {
 
      // Update the Value of ans and Increment i by 1
      ans = (ans + k) % i;
      i++;
    }
 
    // Return required answer
    return ans + 1;
  }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(jos(sc.nextInt(), sc.nextInt()));
        System.out.print(Josephus(sc.nextInt(), sc.nextInt()));
        sc.close();
    }
}

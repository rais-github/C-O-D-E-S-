import java.util.Scanner;
class pattern_for_2D_dp_starting
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row=sc.nextInt();
        int col= sc.nextInt();
        sc.close();
        for(int i=1;i<=row;i++){
        for(int j=1;j<=col;j++)   
        {
           if((i%4==0 && j==1) || (i%2!=0) || (i%4!=0 && j==col))
           {
            System.out.print("# ");
           }else System.out.print(". ");
        }
        System.out.println();}
    }
}
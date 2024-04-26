import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
        {
            int n = sc.nextInt();
            printAveragePermut(n);
        }
    }
    private static void printAveragePermut(int n)
    {
        if (n == 3)
        {
            System.out.print(1 + " " + 2 + " " + 3);
            System.out.print("\n");
        }

        else {
            int[] nums = new int[n];
            nums[0] = n;
            nums[n - 1] = n - 1;
            nums[n - 2] = n - 2;
            nums[1] = n - 3;
            // keeping the biggest number farthest so to avoid coming in same triplet;

            // now sequentially arrange the numbers from 1 as this will not alter the triplets 
            
           int num=1;
           int idx=2;
           while(nums[idx]==0)
           {
               nums[idx++]=num++;
           }

            for (int number: nums)
            {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}

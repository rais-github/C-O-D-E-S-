/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0 ){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    
		    int a[] = new int[n];
		    
		    for (int i = 0 ; i < n ; i++ ) a[i] = sc.nextInt();
		    
		    PriorityQueue<Integer> to = new PriorityQueue<>();
		    
		    PriorityQueue<Integer> mo = new PriorityQueue<>(Collections.reverseOrder());
		    
		    for( int i = 0 ; i < n ; i++){
		        
		        if( ( i & 1 ) == 0 ) mo.add( a[i] );
		        else to.add( a[i] );
		        
		    }
		    
		  //  System.out.println( to.toString() + " " + mo.toString() );
		    
		    while( k > 0  ){
		        
		        if(  !to.isEmpty() && !mo.isEmpty() && to.peek() < mo.peek() ){
		            int temp = to.remove();
		            int temp1 = mo.remove();
		            to.add( temp1 );
		            mo.add( temp );
		        }
		        else{
		            break;
		        }
		        k--;
		        
		    }
		    
		    long tSum = 0;
		    
		    long mSum = 0;
		    
		  //  System.out.println( to.toString() + " " + mo.toString() );
		    
		    
		    while( !to.isEmpty() ){
		        tSum += to.remove();
		    }
		    
		    while( !mo.isEmpty() ){
		        mSum += mo.remove();
		    }
		    
		    if( mSum < tSum ){
		        System.out.println( "YES" );
		    }
		    else{
		        System.out.println("NO");
		    }
		    
		  //  System.out.println( mSum + " " + tSum );
		}
	}
}

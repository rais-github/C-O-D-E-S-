import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char str[] = input.toCharArray();
		Arrays.sort(str);
		String sortedStr = new String(str);
		HashSet<String> set = new HashSet<>();
		smallD(sortedStr,"",input,set);
    }
	public static void smallD(String sortedStr,String out , String input,HashSet<String> set){
		if(sortedStr.length()==0 && (out.compareTo(input)<0 ||  out.compareTo(input)==0 ||  out.compareTo(input)>0)){
			if(set.contains(out))
			return;
			set.add(out);
			System.out.println(out);
		}
		for(int ci=0;ci<sortedStr.length();ci++){
			char cith=sortedStr.charAt(ci);
			smallD(sortedStr.substring(0,ci)+sortedStr.substring(ci+1),out+cith,input,set);
		}
	}
}

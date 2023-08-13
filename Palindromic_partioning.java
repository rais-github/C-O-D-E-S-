public class Solution {
	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		ArrayList<String> path = new ArrayList<>();
		partitioning(a,0,path,res);
		return res;
	}
	public static void partitioning(String a,int idx,ArrayList<ArrayList<String>> res, ArrayList<String> path)
	{
		if(idx==a.length())
		{
			res.add(new ArrayList<>(path));
			return;
		}
		for(int i=idx;i<a.length;i++)
		{
			if(isPalindrome(a,idx,i))
			path.add(a.subString(i+1));
			partitioning(a,idx+1,path,res);
			path.remove(path.size()-1);
		}
	}
	public static boolean isPalindrome(String a,int start,int end)
	{
		while(start<=end)
		{
			a.charAt(start++)!=a.charAt(end--) return false;
		}
		return true;
	}
}

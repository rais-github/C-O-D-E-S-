class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> res = space(S);
        return res;
    }
    public static ArrayList<String> space(String s)
    {
        ArrayList<String> str = new ArrayList<>();
        if(s.length==1)
        {
            str.add(s);
            return str;
        }
        ArrayList<String> temp  = space(s.substring(1,s.length()));
        for(int i = 0 ;i<temp.size();i++)
        {
            str.add(s.charAt(0)+temp.get(i));
            str.add(s.charAt(0)+' '+temp.get(i));
        }
        return str;
    }
    
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0,right=0,n=s.length(),l=0;
        while(right<n)
        {
            if(map.containsKey(s.charAt(right))){
                left=Math.max(left,map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            l=Math.max(l,right-left+1);
            right++;
        }
        return l;
        
    }
}

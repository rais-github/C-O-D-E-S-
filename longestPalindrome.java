class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return 1;
        int[] freq = new int[123];
        for (char ch : s.toCharArray()) {
            freq [ ch ] = freq [ ch ] + 1;
        }
        int length = 0;
        byte oddPick = 0;
        for(int i = 65 ; i < 123 ; i=i+1)
        {
            
            if((freq[i]&1)==0)
            {
                length=length+freq[i];
            }
            else{
                if(oddPick==0)
                {
                    oddPick=1;
                    length += freq[i];
                }
                else{
                    length += (freq[i] / 2) * 2;
                }
            }
        }
        return length;
    }
}

class Solution
{
    public:
    void helper(string s,string &largestNumber,int k,int idx)
    {
        // agar number of swaps khatam hogaye toh return hojao
        if(k==0)
        {
            return;
        }
        int n = s.size();
        // current string ka first character hum maan rahe hai ki largest character hai string mein
        char maxChar = s[idx];
        // ab string mein aage traverse karke find karne ki koshish karenge ki current max character max hai ya aage koyi aur character hai 
        // jo ki maximum character ban sakta hai toh usse appne paas rakhlenge
        for(int i=idx+1;i<n;i++)
        {
            if(maxChar<s[i])
            {
                maxChar = s[i];
            }
        }
        // agar current character jisse humne max character maana tha intially maximum character nahi hai toh iska matlab swap karna padega
        if(maxChar!=s[idx])
        {
            k -= 1;
        }
        for(int i=idx;i<n;i++)
        {
            // ab hum string mein traverse karke maximum character ki position tak jaayenge and phir current character and maximum character
            //  ko swap karke check karenge ki current string maximum hai ya phir largestNumber waala string maximum hai
            if(s[i]==maxChar)
            {
                swap(s[i],s[idx]);
                if(s.compare(largestNumber)>0)
                {
                    largestNumber = s;
                }
                helper(s,largestNumber,k,idx+1);
                // backtracking step
                swap(s[i],s[idx]);
            }
        }
    }
    
    
    string findMaximumNum(string str, int k)
    {
    //   Hum initially yehi maan kar chal rahe hai ki hamara given string hi maximum string hai
       string largestNumber = str;
       helper(str,largestNumber,k,0);
       return largestNumber;
    }
};
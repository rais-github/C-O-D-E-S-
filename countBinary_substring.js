/**
 * @param {string} s
 * @return {number}
 */
var countBinarySubstrings = function(s) {
    if(s.length==0) return 0;
    // if(s.length==1) return 1;
   let cnt=0,cur=1,pre=0;
    for(let i=1;i<s.length;i++)
    {
        if(s[i]==s[i-1]) cur++;
        else
        {
            pre=cur;
            cur=1;
        }
            if(pre>=cur) cnt++;
    }
    return cnt;

};
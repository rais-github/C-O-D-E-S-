public class partion_labels {
    class Solution {
        public:
            vector<int> partitionLabels(string s) {
             unordered_map<char,int>mp;
             for(int i=0;i<s.size();i++)
             {
                 char cur = s[i];
                 mp[cur]=i;
             }
             vector<int> ans;
            int start=0,end=0;
            for(int i =0;i<s.size();i++)
            {
                end=max(end,mp[s[i]]);
                if(i==end)
                {
                    ans.push_back(end-start+1);
                    start=end+1;
                }
            }
            return ans;
            }
        };
}

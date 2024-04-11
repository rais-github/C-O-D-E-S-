class Solution {
public:
    string removeKdigits(string num, int k) {
        int size = num.length();
        if(size == k) return "0";
        stack<char> stk;
        int cnt = 0;
        string s = "";
        stk.push(num[0]);
        for(int i = 1; i < size; i++) {
            while(!stk.empty() && cnt < k && stk.top() > num[i]) {
                stk.pop();
                cnt++;
            }
            stk.push(num[i]);
        }
        while(cnt < k) {
            stk.pop();
            cnt++;
        }
        while(!stk.empty()) {
            s += stk.top();
            stk.pop();
        }
        reverse(s.begin(), s.end());
        // Remove leading zeros
        int idx = 0;
        while(idx < s.length() && s[idx] == '0') {
            idx++;
        }
        if(idx == s.length()) return "0"; // All digits were zero
        return s.substr(idx);
    }
};

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty()) return;
        int temp = s.pop();
        reverse(s);
        down(s,temp);
    }
    static void down(Stack<Integer> s, int temp)
    {
        if(s.isEmpty()){s.push(temp); return ;}
        int top = s.pop();
        down(s,temp);
        s.push(top);
    }
}

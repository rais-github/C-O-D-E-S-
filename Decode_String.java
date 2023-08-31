class solution{
    static int idx=0;
    public static String decode(String s)
    {
        StringBuilder sb = new StringBuilder();
        int n=0;
        while(idx<s.length())
        {
            char cur= s.charAt(idx);
            if(Character.isDigit(cur))
            {
                idx++;
                n=n*10+(cur-'0');
            }
            if(cur=='[')
            {
                String nested=decode(s);
                for(int i=0;i<n;i++)
                {
                    sb.append(nested);
                }
                n=0;
            }
            if(cur==']')
            {
                idx++;
                return sb.toString();
            }
            else{
                sb.append(cur);
                idx++;
            }
        }
        return sb.toString();
    }
}
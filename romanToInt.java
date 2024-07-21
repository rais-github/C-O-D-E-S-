class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n = s.length();
        int maxTillI = map.get(s.charAt(n-1));
        int num = maxTillI;
        for(int i = n-2 ; i >=0 ; i--)
        {
            if(map.get(s.charAt(i))>=maxTillI)
            {
                maxTillI=map.get(s.charAt(i));
                num+=maxTillI;
            }else{
                num-=map.get(s.charAt(i));
            }
        }
        return num;
    }
}

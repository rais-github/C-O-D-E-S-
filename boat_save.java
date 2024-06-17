class Solution {
    public int numRescueBoats(int[] p, int l) {
        Arrays.sort(p);
        int i=0,c=0,j=p.length-1;
        while(i<=j){
            if(p[i]+p[j]<=l){
                c++;
                j--;
                i++;
            }
            else{
                c++;
                j--;
            }
        }
        return c;
    }
}

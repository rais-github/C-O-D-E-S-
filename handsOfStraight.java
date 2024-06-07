class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false; // if there are not enough cards
        Arrays.sort(hand);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            if(map.get(hand[i])==null)
            {
                map.put(hand[i],1);
            }
            else{
                map.put(hand[i],map.get(hand[i])+1);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (map.get(hand[i]) == 0) continue;
            
            for (int j = 0; j < groupSize; j++) {
                int card = hand[i] + j;
                if (!map.containsKey(card) || map.get(card) == 0) {
                    return false;
                }
                map.put(card, map.get(card) - 1);
            }
        }
        
        return true;
    }
}


class Solution 
{
    static class Pair{
        int start,end;
        Pair(int start,int end)
        {
            this.start=start;
            this.end=end;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Pair> list = new ArrayList<>();
        for(int i =0;i<start.length;i++)
        {
            list.add(new Pair(start[i],end[i]));
        }
        Collections.sort(list,(a,b)->a.end-b.end);
        int cnt=1,ansEnd=list.get(0).end;
        for(int i =1;i<start.length;i++)
        {
            if(list.get(i).start>ansEnd)
            {
                cnt++;
                ansEnd=list.get(i).end;
            }
        }
        return cnt;
    }
}

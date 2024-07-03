
// sort the arrays so as to use greedy and dp
public static int minDiff(int []boys , int []girls , int i , int j)
{
  if(i==boys.length) return 0;
  if(j==girls.length) return 9999999;
  int pair = Math.abs(boys[i]-girls[i]) + minDiff(boys,girls,i+1,j+1);
  int noPair = minDiff(boys,girls,i,j+1);
  return Math.min(noPair,pair);
}

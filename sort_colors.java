class Solution {
    public void sortColors(int[] a) {
   int low=0,mid=0,high= a.length-1;

   if(a.length==1){
       return;
   }

        while(mid<=high){
            if(mid<=high && a[mid]==0){
                swap(a,mid,low);
                low++;
                mid++;
            }
            if(mid<=high && a[mid]==2){
                swap(a,mid,high);
                high--;
            }
            if(mid<=high && a[mid]==1){
                mid++;
            }
        } 
    }
    static void swap(int[] a,int first,int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}

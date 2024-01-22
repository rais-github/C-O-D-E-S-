class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        unqSubsequence(0,nums,new ArrayList<>(),res);
        return res;
    }
    public static void unqSubsequence(int idx,int nums[],List<Integer> lst,List<List<Integer>> res){
        if(res.contains(lst)) return;
        if(idx==nums.length){ res.add(new ArrayList<>(lst));
        return;}
        lst.add(nums[idx]);
        unqSubsequence(idx+1,nums,lst,res);
        lst.remove(lst.size()-1);
        unqSubsequence(idx+1,nums,lst,res);
    }
}

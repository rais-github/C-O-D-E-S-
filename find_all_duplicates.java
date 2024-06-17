class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(index + 1);// if the element encounterd is alredy tracked previous hence duplicate thereby add to returing list
            } else {
                nums[index] = -nums[index];// this is done for marking that the element has been ecountrd for the first time
            }
        }
        
        return duplicates;
    }
}

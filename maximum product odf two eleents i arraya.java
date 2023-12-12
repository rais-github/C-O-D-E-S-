class Solution {
    public int maxProduct(int[] nums) {
        int largest = nums[0];
        int secondLargest = nums[1];

        if(secondLargest > largest){
            int temp = largest;
            largest = secondLargest;
            secondLargest = temp;
        } 

        for(int i= 2; i < nums.length ; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            }else if(nums[i] > secondLargest){
                secondLargest = nums[i];
            }
        }

        return (secondLargest -1) * (largest - 1);


    }
}

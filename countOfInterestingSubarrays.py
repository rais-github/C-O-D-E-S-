class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        prefix={0:1}
        count=0
        curr_sum=0
        for num in nums:
            if num%modulo==k:
                curr_sum+=1
            count+=prefix.get((curr_sum-k)%modulo,0)
            prefix[curr_sum%modulo]=prefix.get(curr_sum%modulo,0)+1
        return count
        
       

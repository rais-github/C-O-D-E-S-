public class Solution {
    public static int longestSubarrayWithSumK(int[] a, long k) {
        int right = 0, left = 0, len = 0, size = a.length;
        long sum = 0;
        
        while (right < size) {
            sum += a[right];

            while (left <= right && sum > k) {
                sum = sum - a[left];
                left++;
            }

            if (sum == k) {
                len = Math.max(len, right - left + 1);
            }

            right++;
        }

        return len;
    }
}

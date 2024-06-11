class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxi = Integer.MIN_VALUE;
        // find the  max element from first array
        for (int ele : arr1) {
            maxi = Math.max(maxi, ele);
        }

        int[] temp = new int[maxi + 1];
        // Count the frequency
        for (int i = 0; i < arr1.length; i++) {
            temp[arr1[i]]++;
        }

        int[] ans = new int[arr1.length];
        int j = 0;

        // Add elements from arr2 in the order they appear in arr2
        for (int i = 0; i < arr2.length; i++) {
            int freq = temp[arr2[i]];
            while (freq-- > 0) {
                ans[j++] = arr2[i];
            }
            // Set frequency to 0 after adding to result array
            temp[arr2[i]] = 0;
        }

        // Add the remaining elements not in arr2
        for (int i = 0; i <= maxi; i++) {
            while (temp[i]-- > 0) {
                ans[j++] = i;
            }
        }

        return ans;
    }
}

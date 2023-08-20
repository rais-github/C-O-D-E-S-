class Solution {
    public int minimumSum(int n, int k) {
        int[] result = new int[n];
        int num = 1;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int j = 0; j < i; j++) {
                if (result[j] + num == k) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result[i] = num;
                sum += num;
            } else {
                i--;
            }
            
            num++;
        }
        
        return sum;
    }
}

class Solution {
    private int myAtoiHelper(int idx, int num, int len, String s, Boolean isNegative) {
        // base cases
        if (idx >= len || !Character.isDigit(s.charAt(idx))) {
            return isNegative ? -num : num;
        }

        int digit = s.charAt(idx) - '0';

        // Check for overflow
        if (num > (Integer.MAX_VALUE - digit) / 10) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        // Recursive calls
        num = num * 10 + digit;
        idx=idx+1;
        return myAtoiHelper(idx, num, len, s, isNegative);
    }

    public int myAtoi(String s) {
        int n = s.length();
        boolean isNegative = false;
        int i = 0, num = 0;

        // Ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') i++;

        // Check if the first non-whitespace character is '-' or '+'
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        // Call the helper function
        return myAtoiHelper(i, num, n, s, isNegative);
    }
}

  class Solution {
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
        // Convert digits to integer (this will only loop if it is digit)
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // Check for overflow and underflow
            // so that after multiplying it remains within bound
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return isNegative ? -num : num;
    }
}

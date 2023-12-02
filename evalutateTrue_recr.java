public class evalutateTrue_recr {
    public int solve(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {
            int lt = solve(s, i, k - 1, true);
            int rf = solve(s, k + 1, j, false);
            int rt = solve(s, i, k - 1, true);
            int lf = solve(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += lt * rt;
                } else ans += lt * rf + lf * rt + lf * rf;
            } else if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += lt * rt + lt * rf + rt * lf;
                } else ans += lf * rf;
            } else {
                if (isTrue) {
                    ans += lt * rf + rt * lf;
                } else ans += lf * rf + lt * rt;
            }
        }
        return ans;
    }
}

class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        vector<int> res(2, 0);
        int low = 0, high = m-1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int maxi = mat[0][mid];
            int idx = -1;
            for (int i = 1; i < n; i++) {
                if (maxi < mat[i][mid]) {
                    idx = i;
                    maxi = mat[i][mid];
                }
            }
            int left = mid - 1 > 0 ? mat[idx][mid - 1] : -1;
            int right = mid + 1 < m ? mat[idx][mid + 1] : -1;

            if (maxi > left && maxi > right) {
                res[0] = idx;
                res[1] = mid;
                return res;
            } else if (maxi < left) {
                // eliminate right and move towards left peak (downslope)
                high = mid - 1;
            } else
                low = mid + 1;
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
};

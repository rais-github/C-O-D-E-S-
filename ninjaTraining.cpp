#include <vector>
#include <algorithm>

class ninjaTraining {
public:
    int ninjaPractice(int n, std::vector<std::vector<int>> points, char optimization) {
        if (optimization == 'r')
            return solver(n - 1, 3, points);
        if (optimization == 'm'){
            std::vector<std::vector<int>> memo(n, std::vector<int>(3, -1));
            return solvem(n - 1, 3, points, memo);
        }
        if (optimization == 't')
            return solvet(n, 3, points);
        
        // Handle invalid optimization value
        return -1;
    }

private:
    int solver(int day, int last, const std::vector<std::vector<int>>& points) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = std::max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + solver(day - 1, task, points);
                maxi = std::max(maxi, point);
            }
        }
        return maxi;
    }

private:
    int solvem(int day, int last, const std::vector<std::vector<int>>& points, std::vector<std::vector<int>>& memo) {
        if (memo[day][last] != -1) return memo[day][last];
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = std::max(maxi, points[0][task]);
                }
            }
            return memo[day][last] = maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + solvem(day - 1, task, points, memo);
                maxi = std::max(maxi, point);
            }
        }
        memo[day][last] = maxi;
        return maxi;
    }
    
private:
    int solvet(int n, int last, const std::vector<std::vector<int>>& points) {
        std::vector<std::vector<int>> dp(n, std::vector<int>(4, 0));

        for (int j = 0; j < 4; j++) {
            dp[0][j] = (j == 3) ? 0 : points[0][j];
        }

        for (int day = 1; day < n; day++) {
            for (int j = 0; j < 4; j++) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        maxi = std::max(maxi, point);
                    }
                }
                dp[day][j] = maxi;
            }
        }

        return dp[n - 1][3];
    }
};

int main() {
    ninjaTraining training;
    
    int n = 5;
    std::vector<std::vector<int>> points = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
    int result = training.ninjaPractice(n, points, optimization);
    
    return 0;
}

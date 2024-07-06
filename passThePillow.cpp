class Solution {
public:
    int passThePillow(int n, int time) {
        if (n > time) {
            return time + 1;
        } else if (n == time) {
            if (time < 3)
                return (n % time) + 1;
            return time - 1;
        } else {
            int cycleTime = 2 * (n - 1);
            int effectiveTime = time % cycleTime;
            if (effectiveTime < n) {
                return effectiveTime + 1;
            } else {
                return 2 * n - effectiveTime - 1;
            }
        }
        return -1;
    }
};

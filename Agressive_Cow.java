import java.util.*;
public class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int minGap = 1, maxGap = stalls[stalls.length - 1] - stalls[0];
        while (minGap <= maxGap) {
            int currentGap = (maxGap + minGap) / 2;
            if (isPossible(currentGap, stalls, k)) {
                minGap = currentGap + 1;
            } else {
                maxGap = currentGap - 1;
            }
        }
        return maxGap; // as this was pointing to not possible gap initially hence due to opposite polarity
    }

    private static boolean isPossible(int gap, int stalls[], int k) {
        int cows = 1, lastPlacedAt = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            int distance = stalls[i] - lastPlacedAt;
            if (distance>= gap) {
                cows++;
                lastPlacedAt = stalls[i];
            }
            if (cows >= k) return true;
        }
        return false;
    }
}

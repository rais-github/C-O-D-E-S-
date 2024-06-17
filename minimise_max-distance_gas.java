import java.util.PriorityQueue;

public class Pair {
    int distance, secIdx;

    Pair(int distance, int secIdx) {
        this.distance = distance;
        this.secIdx = secIdx;
    }
}

public class Solution {
    public static double MinimiseMaxDistance(int[] arr, int K) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.distance - x.distance);
        int[] gasPlaces = new int[n];

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair(arr[i + 1] - arr[i], i));
        }

        for (int gasStation = 1; gasStation <= K; gasStation++) { // Corrected variable name from 'k' to 'K'
            Pair pair = pq.poll();
            int distance = pair.distance;
            int secIdx = pair.secIdx;
            gasPlaces[secIdx]++;
            double initialDifference = arr[secIdx + 1] - arr[secIdx];
            double newSecLen = initialDifference / (double) gasPlaces[secIdx];
            pq.offer(new Pair((int) newSecLen, secIdx));
        }

        return pq.peek().distance;
    }
    private static int numberOfGasStationRequired(int[] arr, double distance) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / distance);
            if ((arr[i] - arr[i - 1]) / distance == numberInBetween * distance) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double MinimiseMaxDistanceUsingBS(int[] arr, int K) {
        // Write your code here.
        int n = arr.length;
        double low = 0; 
        double high = 0; 

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (high + low) / 2.0; 
            int cnt = numberOfGasStationRequired(arr, mid);
            if (cnt > K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}

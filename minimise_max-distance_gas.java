
public class Pair {
    int distance, secIdx;

    Pair(int distance, int secIdx) {
        this.distance = distance;
        this.secIdx = secIdx;
    }
}
import java.util.PriorityQueue;

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
}

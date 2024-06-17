class Pair {
    int rank, place;
    public Pair(int first, int second) {
        this.rank = first;
        this.place = second;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(x -> x.rank)));
        for (int i = 0; i < score.length; i++) {
            pq.offer(new Pair(score[i], i));
        }
        String[] answer = new String[score.length];
        int medal = 0;
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        while (!pq.isEmpty()) {
            Pair item = pq.poll();
            int idx = item.place;
            if (medal < 3) {
                answer[idx] = medals[medal++];
            } else {
                answer[idx] = String.valueOf(++medal);
            }
        }
        return answer;
    }
}

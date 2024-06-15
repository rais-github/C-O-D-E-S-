class Pair {
    int capital, profit;

    public Pair(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<Pair> capHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        PriorityQueue<Pair> profitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        for (int i = 0; i < n; i++) {
            capHeap.offer(new Pair(capital[i], profits[i]));
        }

        while (k-- > 0) {
            while (!capHeap.isEmpty() && capHeap.peek().capital <= w) {
                profitHeap.offer(capHeap.poll());
            }

            if (profitHeap.isEmpty()) {
                break;
            }

            w += profitHeap.poll().profit;
        }

        return w;
    }
}

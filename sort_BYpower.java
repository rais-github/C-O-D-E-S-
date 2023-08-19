import java.util.*;

class Solution {
    public int getKth(int lo, int hi, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            numbers.add(i);
        }
        Collections.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                int powerComparison = Integer.compare(steps(num1), steps(num2));
                return powerComparison != 0 ? powerComparison : Integer.compare(num1, num2);
            }
        });

        return numbers.get(k - 1);
    }

    public static int steps(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            count++;
        }
        return count;
    }
}

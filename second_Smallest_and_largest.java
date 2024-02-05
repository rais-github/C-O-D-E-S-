public class Solution {
    public static int[] getSecondOrderElements(int n, int[] a) {
        int secondLargest = secondLargestElement(n, a);
        int secondSmallest = secondSmallestElement(n, a);
        return new int[]{secondLargest, secondSmallest};
    }

    private static int secondLargestElement(int n, int[] a) {
        int largest = a[0], secondLargest = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            }
            else if (a[i] < largest && a[i]>secondLargest) {
                secondLargest = a[i];
            }
        }
        return secondLargest;
    }

    private static int secondSmallestElement(int n, int[] a) {
        int smallest = a[0], secondSmallest =Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] > smallest && secondSmallest>a[i]) {
                secondSmallest = a[i];
            }
        }
        return secondSmallest;
    }
}

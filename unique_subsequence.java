import java.util.*;

class solve {
    // Function to find all possible unique subsets in lexicographical order.
    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int N) {
        // Sort the input array in ascending order
        Arrays.sort(arr);

        // Use TreeSet to automatically eliminate duplicates and maintain order
        TreeSet<ArrayList<Integer>> resSet = new TreeSet<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                // Compare lexicographically
                int size = Math.min(a.size(), b.size());
                for (int i = 0; i < size; i++) {
                    int cmp = a.get(i).compareTo(b.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        for (int i = 0; i < (1 << N); i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            resSet.add(subset); // Add the subset to the TreeSet
        }

        // Convert the TreeSet to an ArrayList and return
        return new ArrayList<>(resSet);
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        String input = sc.next();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String sortedInput = new String(chars);
        findPermutations("", sortedInput, input);
    }

    public static void findPermutations(String prefix, String sortedInput, String input) {
        if (sortedInput.length() == 0 && prefix.compareTo(input) > 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < sortedInput.length(); i++) {
            char currentChar = sortedInput.charAt(i);
            String newPrefix = prefix + currentChar;
            String newSortedInput = sortedInput.substring(0, i) + sortedInput.substring(i + 1);
            findPermutations(newPrefix, newSortedInput, input);
        }
    }
}

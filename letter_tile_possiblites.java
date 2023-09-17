class Solution {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars); // Sort the characters for easy counting
        boolean[] used = new boolean[chars.length];
        return backtrack(chars, used, 0);
    }

    private int backtrack(char[] chars, boolean[] used, int index) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                // If the current character is different from the previous character (avoid duplicates)
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true; // Mark the character as used
                count++; // Increment the count for the current sequence
                count += backtrack(chars, used, index + 1); // Recursively explore further sequences
                used[i] = false; // Backtrack and mark the character as unused
            }
        }
        return count;
    }
}

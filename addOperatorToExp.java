class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> possibilities = new ArrayList<>();
        if (num == null || num.length() == 0) return possibilities;
        backtrack(possibilities, num, new StringBuilder(), target, 0, 0, 0);
        return possibilities;
    }

    private void backtrack(List<String> res, String num, StringBuilder path, int target, long calculated, long tail, int index) {
        // Base case: if we've reached the end of the string
        if (index == num.length()) {
            if (calculated == target) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Avoid numbers with leading zeroes
            if (i != index && num.charAt(index) == '0') break;
            
            // Get the current number as a string and convert to a long
            String currentStr = num.substring(index, i + 1);
            long currentNum = Long.parseLong(currentStr);
            int pathLength = path.length();  // Record path length before adding

            if (index == 0) {
                // First number in the expression, just move forward without adding an operator
                path.append(currentStr);
                backtrack(res, num, path, target, currentNum, currentNum, i + 1);
                path.setLength(pathLength);  // Backtrack
            } else {
                // Explore the addition operator
                path.append("+").append(currentStr);
                backtrack(res, num, path, target, calculated + currentNum, currentNum, i + 1);
                path.setLength(pathLength);  // Backtrack

                // Explore the subtraction operator
                path.append("-").append(currentStr);
                backtrack(res, num, path, target, calculated - currentNum, -currentNum, i + 1);
                path.setLength(pathLength);  // Backtrack

                // Explore the multiplication operator
                path.append("*").append(currentStr);
                backtrack(res, num, path, target, calculated - tail + tail * currentNum, tail * currentNum, i + 1);
                path.setLength(pathLength);  // Backtrack
            }
        }
    }
}

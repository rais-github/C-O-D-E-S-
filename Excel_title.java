class Solution {
    // static String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // static char map[] = str.toCharArray();

    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            res.insert(0, remainder + 'A');
            columnNumber /= 26;
        }

        return res.toString();
    }
}

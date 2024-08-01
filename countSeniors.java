class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String s : details) {
            String ageStr = s.substring(11, 13);
            int age = Integer.parseInt(ageStr);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}

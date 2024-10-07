public class generateAllBinaryString {
    public static void main(String[] args) {
        int n = 3;
        // generateAllBinaryString(n, "");
        generateAllBinaryStringWithoutConsecutiveOnes(n, "");
    }

    public static void generateAllBinaryString(int n, String output) {
        if (n == 0) {
            System.out.println(output);
            return;
        }
        generateAllBinaryString(n - 1, output + "0");
        generateAllBinaryString(n - 1, output + "1");
    }
    private static void generateAllBinaryStringWithoutConsecutiveOnes(int n, String output) {
        if (n == 0) {
            System.out.println(output);
            return;
        }
        if (output.length() == 0 || output.charAt(output.length() - 1) == '0') {
            generateAllBinaryStringWithoutConsecutiveOnes(n - 1, output + "0");
            generateAllBinaryStringWithoutConsecutiveOnes(n - 1, output + "1");
        } else {
            generateAllBinaryStringWithoutConsecutiveOnes(n - 1, output + "0");
        }
    }
    
}

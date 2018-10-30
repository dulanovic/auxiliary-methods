package api;

public class LCS {

    private LCS() {}

    public static int calculate(String s1, String s2) {
        int[][] lengths = new int[s1.length() + 1][s2.length() + 1];
        String maxSubsequence = "";
        int maxLength = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lengths[i][j] = lengths[i + 1][j + 1] + 1;
                    if (lengths[i][j] > maxLength) {
                        maxLength++;
                        maxSubsequence = s2.charAt(j) + maxSubsequence;
                    }
                } else {
                    lengths[i][j] = Math.max(lengths[i][j + 1], lengths[i + 1][j]);
                }
            }
        }
        System.out.printf("%s\n", maxSubsequence);
        return lengths[0][0];
    }
}

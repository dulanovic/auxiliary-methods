public class Hadamard {

    private Hadamard() {}

    public static boolean[][] hadamard(int arg) {
        if (!Mathematics.isPowerOf2(arg)) {
            System.err.println("Provided argument is not a power of 2!!!");
            return null;
        }
        if (arg == 1) {
            System.out.printf("%s\n", '1');
            return null;
        }
        boolean[][] hadamard = {{true}};
        for (int i = 2; i <= arg; i *= 2) {
            boolean[][] temp = new boolean[i][i];
            for (int j = 0, row = 0; j < i; j++, row++) {
                if (row == i / 2) {
                    row = 0;
                }
                for (int k = 0, column = 0; k < i; k++, column++) {
                    if (column == i / 2) {
                        column = 0;
                    }
                    temp[j][k] = hadamard[row][column];
                }
            }
            hadamard = temp;
            for (int l = i / 2; l < i; l++) {
                for (int m = i / 2; m < i; m++) {
                    if (hadamard[l][m]) {
                        hadamard[l][m] = false;
                    } else {
                        hadamard[l][m] = true;
                    }
                }
            }
        }
        /* System.out.println("HADAMARD MATRIX:");
        for (int i = 0; i < arg; i++) {
            for (int j = 0; j < arg; j++) {
                System.out.printf("%s ", hadamard[i][j]);
            }
            System.out.println();
        } */
        return hadamard;
    }

    public static boolean[][] hadamardKW(int n) {
        if (!Mathematics.isPowerOf2(n)) {
            System.err.println("Provided argument is not a power of 2!!!");
            return null;
        }
        boolean[][] hadamard = new boolean[n][n];
        hadamard[0][0] = true;
        for (int k = 1; k < n; k += k) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    hadamard[i + k][j] = hadamard[i][j];
                    hadamard[i][j + k] = hadamard[i][j];
                    hadamard[i + k][j + k] = !hadamard[i][j];
                }
            }
        }
        /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hadamard[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        } */
        return hadamard;
    }
}

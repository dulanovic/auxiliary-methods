package api;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Mathematics {

    private Mathematics() {}

    public static double sqrt(double number) {
        double epsilon = 1e-15, t = number;
        while (java.lang.Math.abs(t - number / t) > epsilon * t) {
            t = (t + number / t) / 2.0;
        }
        return t;
    }

    public static void ramanujan(int number) {
        int counter = 0;
        for (int a = 1; a <= number; a++) {
            int a3 = a * a * a;
            if (a3 > number) {
                break;
            }
            for (int b = a + 1; b <= number; b++) {
                int b3 = b * b * b;
                if (a3 + b3 > number) {
                    break;
                }
                for (int c = a + 1; c <= number; c++) {
                    int c3 = c * c * c;
                    if (c3 > a3 + b3) {
                        break;
                    }
                    for (int d = c + 1; d <= number; d++) {
                        int d3 = d * d * d;
                        if (a3 + b3 < c3 + d3) {
                            break;
                        }
                        if (a3 + b3 == c3 + d3) {
                            counter++;
                            System.out.printf("a ---> %d, b ---> %d, c ---> %d, d ---> %d\n", a, b, c, d);
                            System.out.printf("%d^3 + %d^3 = %d^3 + %d^3 = %d\n\n", a, b, c, d, a3 + b3);
                        }
                    }
                }
            }
        }
        System.out.printf("Method finished. %d Ramanujan numbers found.\n", counter);
    }

    public static void functionGrowth() {
        String output = "ln(n) \tn \tn*ln(n) \tn^2 \tn^3 \t2^n\n";
        for (int i = 2; i <= 2048; i *= 2) {
            output += String.format("%d\t%d\t%d\t%d\t%d\t%d\n", (int) Math.log(i), i, (int) (i * Math.log(i)), i * i, i * i * i, (int) Math.pow(2.0, i));
        }
        System.out.println(output);
    }

    public static boolean isPrime(int number) {
        boolean isPrime = true;
        if (number < 2) {
            isPrime = false;
        }
        for (long factor = 2; factor * factor <= number; factor++) {
            if (number % factor == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static int[] primeFactorization(int number) {
        String factorsString = "";
        for (long factor = 2; factor * factor <= number; factor++) {
            while (number % factor == 0) {
                factorsString += factor + " ";
                number /= factor;
            }
        }
        if (number > 1) {
            factorsString += number;
        }
        String[] factorsArray = factorsString.split(" ");
        int[] factors = new int[factorsArray.length];
        for (int i = 0; i < factorsArray.length; i++) {
            factors[i] = Integer.parseInt(factorsArray[i]);
        }
        return factors;
    }

    public static double exponential(double number) {
        boolean negative = false;
        if (number < 0) {
            negative = true;
            number = -number;
        }
        double elem = 1.0;
        double sum = 0.0;
        for (int i = 1; sum != sum + elem; i++) {
            sum += elem;
            elem *= number / i;
        }
        if (negative) {
            sum = 1.0 / sum;
        }
        return sum;
    }

    public static double[] sinCos(double arg) {
        arg = arg % (2 * Math.PI);
        double sumSin = 0.0, sumCos = 0.0, term = 1.0, coefficient = 1.0;
        for (int i = 0; sumSin != sumSin + term && sumCos != sumCos + term; i++) {
            if (i % 2 != 0) {
                sumSin += coefficient * term;
                coefficient = -coefficient;
            } else {
                sumCos += coefficient * term;
            }
            term *= arg / (i + 1);
        }
        return new double[]{sumSin, sumCos};
    }

    public static long[] euler(long arg) {
        long[] numbers = new long[5];
        long a5, b5, c5, d5, e5;
        for (long e = 1; e <= arg; e++) {
            e5 = e * e * e * e * e;
            for (long a = 1; a <= arg; a++) {
                a5 = a * a * a * a * a;
                if (a5 >= e5) {
                    break;
                }
                for (long b = a; b <= arg; b++) {
                    b5 = b * b * b * b * b;
                    if (a5 + b5 >= e5) {
                        break;
                    }
                    for (long c = b; c <= arg; c++) {
                        c5 = c * c * c * c * c;
                        if (a5 + b5 + c5 >= e5) {
                            break;
                        }
                        for (long d = c; d <= arg; d++) {
                            d5 = d * d * d * d * d;
                            if (a5 + b5 + c5 + d5 > e5) {
                                break;
                            }
                            if (a5 + b5 + c5 + d5 == e5) {
                                System.out.printf("%d^5 + %d^5 + %d^5 + %d^5 = %d^5 <=> %d + %d + %d + %d = %d\n", a, b, c, d, e, a5, b5, c5, d5, e5);
                                long[] array = new long[]{a5, b5, c5, d5, e5};
                                numbers = array;
                            }
                        }
                    }
                }
            }
        }
        if (numbers.length != 0) {
            return numbers;
        }
        return null;
    }

    public static void eratosthenes(int arg) {
        boolean[] isPrime = new boolean[arg + 1];
        for (int i = 2; i <= arg; i++) {
            isPrime[i] = true;
        }
        int primes = arg - 1;
        for (int i = 2; i * i <= arg; i++) {
            // System.out.printf("i ---> %d\n", i);
            if (isPrime[i]) {
                for (int j = i * i; j <= arg; j += i) {
                    // System.out.printf("\tj ---> %d\n", j);
                    if (isPrime[j]) {
                        primes--;
                        // System.out.printf("j ---> %d\n", j);
                    }
                    isPrime[j] = false;
                }
            }
        }
        System.out.printf("Number of primes of %d ---> %d\n", arg, primes);
        /* for (int i = 0; i < isPrime.length; i++) {
            System.out.printf("%d ---> %s\n", i, isPrime[i]);
        } */
    }

    public static String thueMorse(int arg) {
        String thue = "0", morse = "1";
        for (int i = 0; i < arg; i++) {
            String t = thue;
            String m = morse;
            thue += m;
            morse += t;
        }
        return thue;
    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            System.err.println("Matrices(or their first rows) are not the same dimension!!!");
            return null;
        }
        int dimension = a.length;
        int columnLength = a[0].length;
        for (int i = 1; i < dimension; i++) {
            if (columnLength != a[i].length || columnLength != b[i].length) {
                System.err.println("Matrices are not proper(Rows are not the same dimension)");
                return null;
            }
        }
        int[][] result = new int[dimension][columnLength];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < columnLength; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        /* for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < columnLength; j++) {
                System.out.printf("%d\t", result[i][j]);
            }
            System.out.println();
        } */
        return result;
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        if (!adequate(a) || !adequate(b)) {
            System.err.println("Multiplication cannot be performed over these matrices(Columns are not the same dimension)");
            return null;
        }
        if (a[0].length != b.length) {
            System.err.println("Matrices not adequate, dimensions not matching, multiplication aborted");
            return null;
        }
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        /* for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.printf("%d ", result[i][j]);
            }
            System.out.println();
        } */
        return result;
    }

    public static boolean adequate(int[][] matrix) {
        int columnLength = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (columnLength != matrix[i].length) {
                return false;
            }
        }
        return true;
    }

    public static int[] permutation(int m, int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < m; i++) {
            int random = i + (int) (Math.random() * (n - i));
            int temp = array[i];
            array[i] = array[random];
            array[random] = temp;
        }
        /* for (int i = 0; i < m; i++) {
            System.out.printf("%d\n", array[i]);
        } */
        return array;
    }

    public static int discreteDistribution(int[] args) {
        int size = args.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += args[i];
        }
        int random = (int) (Math.random() * sum);
        int accumulative = 0;
        int flag = -1;
        for (int i = 0; i < size && accumulative <= random; i++) {
            accumulative += args[i];
            flag = i;
        }
        return flag;
    }

    public static boolean isRagged(int[][] matrix) {
        int size = matrix.length;
        int rowLength = matrix[0].length;
        for (int i = 1; i < size; i++) {
            if (matrix[i].length != rowLength) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSquare(int[][] matrix) {
        int dimension = matrix.length;
        int rowLength = matrix[0].length;
        if (dimension != rowLength) {
            return false;
        }
        for (int i = 1; i < dimension; i++) {
            if (dimension != matrix[i].length) {
                return false;
            }
        }
        return true;
    }

    public static int[][] transpose(int[][] matrix) {
        if (isRagged(matrix)) {
            System.err.println("Matrix invalid, variable number of columns per row!!!");
            return null;
        }
        int rowCount = matrix[0].length;
        int columnCount = matrix.length;
        int[][] newMatrix = new int[rowCount][columnCount];
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        /* System.out.println("TRANSPOSED MATRIX:");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.printf("%d ", newMatrix[i][j]);
            }
            System.out.println();
        } */
        return newMatrix;
    }

    public static int[][] transposeSquared(int[][] matrix) {
        if (isRagged(matrix)) {
            System.err.println("Matrix not valid, rows are of different lengths!!!");
            return null;
        }
        if (!isSquare(matrix)) {
            System.err.println("Matrix not valid, number of rows and columns is not the same!!!");
            return null;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                if (i == j) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /* System.out.println("TRANSPOSED MATRIX:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        } */
        return matrix;
    }

    public static int[] inverse(int[] array) {
        boolean[] checkArray = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] >= array.length || checkArray[array[i]]) {
                System.err.println("Permutation not valid!!!");
                return null;
            }
            checkArray[array[i]] = true;
        }
        int[] inverse = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            inverse[array[i]] = i;
        }
        /* System.out.println("INVERSED ARRAY:");
        for (int i = 0; i < inverse.length; i++) {
            System.out.printf("%d ", inverse[i]);
        } */
        return inverse;
    }

    public static boolean isPowerOf2(int arg) {
        if (arg != 1 && arg % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= arg; i *= 2) {
            if (i == arg) {
                return true;
            }
        }
        return false;
    }

    /* private static void submatrix(char[][] matrix, int n, int m) {
        if (m < n) {
            System.err.println("Invalid arguments!!!");
            return;
        }
        int size = m - n + 1;
        char[][] submatrix = new char[size][size];
        int row = 0;
        int column = 0;
        for (int i = n; i <= m; i++) {
            for (int j = n; j <= m; j++) {
                // System.out.printf("%s ", matrix[i][j]);
                submatrix[row][column] = matrix[i][j];
                column++;
            }
            // System.out.println();
            row++;
            column = 0;
        }
        System.out.println("PART OF ORIGINAL MATRIX:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s ", submatrix[i][j]);
            }
            System.out.println();
        }
    } */

    private static char[][] submatrix(char[][] matrix, int iMin, int jMin, int iMax, int jMax) {
        if (iMin > iMax || jMin > jMax || iMin < 0 || jMin < 0 || iMax >= matrix.length || jMax >= matrix[0].length) {
            System.err.println("Invalid arguments!!!");
            return null;
        }
        int rowCount = iMax - iMin + 1;
        int columnCount = jMax - jMin + 1;
        char[][] submatrix = new char[rowCount][columnCount];
        for (int i = iMin, row = 0; i <= iMax; i++, row++) {
            for (int j = jMin, column = 0; j <= jMax; j++, column++) {
                submatrix[row][column] = matrix[i][j];
            }
        }
        /* System.out.println("PART OF ORIGINAL MATRIX:");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.printf("%s ", newMatrix[i][j]);
            }
            System.out.println();
        } */
        return submatrix;
    }

    private static char[][] construct(char[][] matrix) {
        int size = matrix.length * 2;
        char[][] submatrix = new char[size][size];
        for (int i = 0, row = 0; i < size; i++, row++) {
            if (row == size / 2) {
                row = 0;
            }
            for (int j = 0, column = 0; j < size; j++, column++) {
                if (column == size / 2) {
                    column = 0;
                }
                submatrix[i][j] = matrix[row][column];
            }
        }
        /* System.out.println("NEW(DOUBLED) MATRIX:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s ", newMatrix[i][j]);
            }
            System.out.println();
        } */
        return submatrix;
    }

    public static void plot(int samples, double min, double max) {
        if (min > max) {
            StdOut.println("MIN > MAX!!!");
            return;
        }
        double increment = Math.PI / samples;
        StdDraw.setScale(min, max);
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(min, 0.0, max, 0.0);
        StdDraw.line(0.0, min, 0.0, max);
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        double argument = min;
        while (argument < max) {
            double value = Math.sin(4 * argument) + Math.sin(20 * argument);
            StdDraw.point(argument, value);
            argument += increment;
        }
        StdOut.println("SIMULATION OVER!!!");
    }

    public static double[] generateDiscreteDistribution(int values) {
        if (values <= 1) {
            StdOut.println("Not possible to generate distribution for <= 1 values!");
            return null;
        }
        double[] distribution = new double[values];
        double sum = 0.0;
        for (int i = 0; i < values; i++) {
            if (i == values - 1) {
                distribution[i] = 1.0 - sum;
                break;
            }
            distribution[i] = StdRandom.uniform();
            sum += distribution[i];
            if (sum > 1.0) {
                sum = 0.0;
                for (int j = 0; j <= i; j++) {
                    distribution[j] = distribution[j] / 2;
                    sum += distribution[j];
                }
            }
        }
        /* StdOut.println("GENERATED DISCRETE DISTRIBUTION:");
        for (int i = 0; i < values; i++) {
            StdOut.printf(" %.3f", distribution[i]);
        }
        StdOut.println("\n"); */
        return distribution;
    }

    public static double[][] generateMatrix(int row, int col) {
        double[][] matrix = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = StdRandom.uniform();
            }
        }
        /* StdOut.println("GENERATED MATRIX:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                StdOut.printf(" %.3f", matrix[i][j]);
            }
            StdOut.println();
        }
        StdOut.println(); */
        return matrix;
    }

    private static boolean sameSign(double a,  double b) {
        return !(a < 0 ^ b < 0);
    }

    public static double integralDef(double a, double b, int steps) {
        if (a >= b) {
            throw new IllegalArgumentException("Arguments not correct, lower bound greater than or equal to upper bound!!!");
        }
        if (steps <= 0) {
            throw new IllegalArgumentException("Argument not correct, number of step less than or equal to zero!!!");
        }
        double sum = 0.0, step = (b - a) / steps, functionArgument = a, stepMin = step / 100;
        while (functionArgument < b) {
            double valueStart = Math.sin(functionArgument) - Math.sin(functionArgument / 2) + Math.sin(functionArgument / 4) - Math.sin(functionArgument / 8) + Math.sin(functionArgument / 16) - Math.sin(functionArgument / 32);
            double pointA = functionArgument;
            functionArgument += step;
            double valueEnd = Math.sin(functionArgument) - Math.sin(functionArgument / 2) + Math.sin(functionArgument / 4) - Math.sin(functionArgument / 8) + Math.sin(functionArgument / 16) - Math.sin(functionArgument / 32);
            double argumentTemp = functionArgument;
            boolean sameSign = sameSign(valueStart, valueEnd);
            while (!sameSign) {
                argumentTemp -= stepMin;
                valueEnd = Math.sin(argumentTemp) - Math.sin(argumentTemp / 2) + Math.sin(argumentTemp / 4) - Math.sin(argumentTemp / 8) + Math.sin(argumentTemp / 16) - Math.sin(argumentTemp / 32);
                sameSign = sameSign(valueStart, valueEnd);
                if (argumentTemp >= b) {
                    valueEnd = 0.0;
                    break;
                }
            }
            double pointB = argumentTemp;
            sum += ((valueStart + valueEnd) / 2) * (pointB - pointA);
        }
        return sum;
    }
    
    public static double pdf(double x, double mean, double stddev) {
        return pdf(x - mean / stddev) / stddev;
    }
    
    public static double pdf(double x) {
        return (1 / Math.sqrt(2.0 * Math.PI)) * Math.exp(-Math.pow(x, 2.0) / 2.0);
    }
    
    public static double cdf(double z) {
        if (z > 8.0) {
            return 1.0;
        }
        if (z < -8.0) {
            return 0.0;
        }
        double sum = 0.0;
        double term = z;
        for (int i = 3; sum + term != sum; i += 2) {
            sum += term;
            term = term * z * z / i;
        }
        return 0.5 + pdf(z) * sum;
    }
    
    public static double cdf(double z, double mean, double stddev) {
        return cdf((z - mean) / stddev);
    }

}

package api;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;

public class IteratedFunctionSystem {

    public static void run(int trials, String filename) {
        In in = new In(filename);
        double[] probabilities = new double[in.readInt()];
        for (int i = 0; i < probabilities.length; i++) {
            probabilities[i] = in.readDouble();
        }
        double[][] coefficientsX = new double[in.readInt()][in.readInt()];
        for (int i = 0; i < coefficientsX.length; i++) {
            for (int j = 0; j < coefficientsX[0].length; j++) {
                coefficientsX[i][j] = in.readDouble();
            }
        }
        double[][] coefficientsY = new double[in.readInt()][in.readInt()];
        for (int i = 0; i < coefficientsY.length; i++) {
            for (int j = 0; j < coefficientsY[0].length; j++) {
                coefficientsY[i][j] = in.readDouble();
            }
        }
        double x = 0.0;
        double y = 0.0;
        StdDraw.enableDoubleBuffering();
        // StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenColor(new Color(247, 106, 4));
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < trials; i++) {
            int random = StdRandom.discrete(probabilities);
            double x1 = coefficientsX[random][0] * x + coefficientsX[random][1] * y + coefficientsX[random][2];
            double y1 = coefficientsY[random][0] * x + coefficientsY[random][1] * y + coefficientsY[random][2];
            x = x1;
            y = y1;
            StdDraw.point(x, y);
            StdDraw.show();
        }
    }

    public static void run(int trials, int dist) {
        double[] distribution = Mathematics.generateDiscreteDistribution(dist);
        double[][] coefX = Mathematics.generateMatrix(dist, 3);
        double[][] coefY = Mathematics.generateMatrix(dist, 3);
        double x = 0.0;
        double y = 0.0;
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-20, 20);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(0.003);
        for (int i = 0; i < trials; i++) {
            int random = StdRandom.discrete(distribution);
            double x0 = coefX[random][0] * x + coefX[random][1] * y + coefX[random][2];
            double y0 = coefY[random][0] * x + coefY[random][1] * y + coefY[random][2];
            x = x0;
            y = y0;
            // StdOut.printf("(x0, y0) ---> (%.3f, %.3f)\n", x0, y0);
            StdDraw.point(x, y);
            StdDraw.show();
        }
        StdDraw.show();
    }

}
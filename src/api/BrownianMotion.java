package api;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class BrownianMotion {

    private BrownianMotion() {}

    public static void curve(double x0, double y0, double x1, double y1, double min, double var, double s) {
        if (Math.abs(x1 - x0) < min) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double stddev = Math.sqrt(var);
        double delta = StdRandom.gaussian(0, stddev);
        curve(x0, y0, xm, ym + delta, min, var / s, s);
        curve(xm, ym + delta, x1, y1, min, var / s, s);
    }

    public static void midpoint(double x0, double y0, double x1, double y1, double var, int n) {
        if (n == 0) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        double xm = (x0 + x1) / 2 + StdRandom.gaussian(0, Math.sqrt(var));
        double ym = (y0 + y1) / 2 + StdRandom.gaussian(0, Math.sqrt(var));
        midpoint(x0, y0, xm, ym, var / 2.7, n - 1);
        midpoint(xm, ym, x1, y1, var / 2.7, n - 1);
    }

    public static void plasma(double x, double y, double size, double stddev, double min, double c1, double c2, double c3, double c4) {
        if (size <= min) {
            return;
        }
        double displacement = StdRandom.gaussian(0, stddev);
        double cm = (c1 + c2 + c3 + c4) / 4 + displacement;
        Color c = Color.getHSBColor((float) cm, 0.75f, 0.75f);
        StdDraw.setPenColor(c);
        StdDraw.filledSquare(x, y, size);
        double ct = (c3 + c4) / 2;
        double cb = (c1 + c2) / 2;
        double cl = (c1 + c4) / 2;
        double cr = (c2 + c3) / 2;
        plasma(x + size / 2, y + size / 2, size / 2, stddev / 2, min, cm, cr, c3, ct);
        plasma(x + size / 2, y - size / 2, size / 2, stddev / 2, min, cb, c2, cr, cm);
        plasma(x - size / 2, y - size / 2, size / 2, stddev / 2, min, c1, cb, cm, cl);
        plasma(x - size / 2, y + size / 2, size / 2, stddev / 2, min, cl, cm, ct, c4);
    }

}

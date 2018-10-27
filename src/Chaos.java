import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Chaos {

    private Chaos() {}

    public static void draw(int trials) {
        double[] coordinateX = {0.0, 1.0, 0.5};
        double[] coordinateY = {0.0, 0.0, Math.sqrt(3) / 2};
        double x = 0.0;
        double y = 0.0;
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        for (int i = 0; i < trials; i++) {
            int random = (int) (Math.random() * 3);
            x = (x + coordinateX[random]) / 2.0;
            y = (y + coordinateY[random]) / 2.0;
            StdDraw.point(x, y);
        }
        StdOut.println("OVER!!!");
    }

}

package api;

public class RandomWalker {

    private RandomWalker() {}

    public static int simulate(int moves) {
        int x = 0, y = 0, distance = 0;
        // System.out.printf("(%d, %d)\n", x, y);
        for (int i = 0; i < moves; i++) {
            double random = Math.random();
            if (random <= 0.25) {
                y++;
            } else if (random <= 0.5) {
                x++;
            } else if (random <= 0.75) {
                y--;
            } else {
                x--;
            }
            // System.out.printf("(%d, %d)\n", x, y);

        }
        distance = x * x + y * y;
        // System.out.printf("SQUARED DISTANCE AFTER %d MOVES ---> %d\n", n, distance);
        return distance;
    }

    public static void simulate(int moves, int trials) {
        int totalDistance = 0;
        for (int i = 0; i < trials; i++) {
            totalDistance += simulate(moves);
        }
        System.out.printf("TOTAL DISTANCE ---> %d\nAVERAGE DISTANCE ---> %.3f\n", totalDistance, 1.0 * totalDistance / trials);
    }
}

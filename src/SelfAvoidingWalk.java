public class SelfAvoidingWalk {

    private SelfAvoidingWalk() {}

    public static void selfAvoidingWalk(int size, int trials) {
        int escapes = 0;
        int collisions = 0;
        int totalIterations = 0;
        for (int i = 0; i < trials; i++) {
            boolean[][] terrain = new boolean[size][size];
            int x = size / 2;
            int y = size / 2;
            terrain[x][y] = true;
            int iterations = 0;
            while (true) {
                String options = "";
                if (x - 1 >= 0) {
                    if (!terrain[x - 1][y]) {
                        options += "u";
                    }
                } else {
                    escapes++;
                    totalIterations += iterations;
                    // System.out.println("ESCAPED!!!");
                    break;
                }
                if (y + 1 <= size - 1) {
                    if (!terrain[x][y + 1]) {
                        options += "l";
                    }
                } else {
                    escapes++;
                    totalIterations += iterations;
                    // System.out.println("ESCAPED!!!");
                    // printStatus(terrain, x, y);
                    break;
                }
                if (x + 1 <= size - 1) {
                    if (!terrain[x + 1][y]) {
                        options += "d";
                    }
                } else {
                    escapes++;
                    totalIterations += iterations;
                    // System.out.println("ESCAPED!!!");
                    // printStatus(terrain, x, y);
                    break;
                }
                if (y - 1 >= 0) {
                    if (!terrain[x][y - 1]) {
                        options += "r";
                    }
                } else {
                    escapes++;
                    totalIterations += iterations;
                    // System.out.println("ESCAPED!!!");
                    // printStatus(terrain, x, y);
                    break;
                }
                if (options.length() == 0) {
                    collisions++;
                    totalIterations += iterations;
                    // System.out.println("COLLISION!!!");
                    // printStatus(terrain, x, y);
                    break;
                } else {
                    int move = (int) (Math.random() * options.length());
                    switch (options.charAt(move)) {
                        case 'u':
                            x--;
                            break;
                        case 'l':
                            y++;
                            break;
                        case 'd':
                            x++;
                            break;
                        case 'r':
                            y--;
                    }
                    terrain[x][y] = true;
                    iterations++;
                    // printStatus(terrain, x, y);
                }
            }
            // System.out.printf("No of iterations ---> %d\n\n", iterations);
        }
        System.out.printf("Trials ---> %d, Total no of iterations ---> %d, Collisions ---> %d, Escapes ---> %d, Percentage of collisions ---> %.1f%%, Percentage of escapes ---> %.1f%%, Avg no of iterations ---> %.3f\n", trials, totalIterations, collisions, escapes, 100.0 * collisions / trials, 100.0 * escapes / trials, 1.0 * totalIterations / trials);
    }

    private void printStatus(boolean[][] terrain, int x, int y) {
        int size = terrain.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == x && j == y) {
                    System.out.print("+");
                }
                System.out.printf("%d ", terrain[i][j] ? 1 : 0);
            }
            System.out.println();
        }
        System.out.println();
    }

}

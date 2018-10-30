package api;

public class CheckerBoard {

    private CheckerBoard() {}

    public static void draw(int arg) {
        int size = arg * 2;
        for (int i = 0; i < arg; i++) {
            for (int j = 0; j < size; j++) {
                if (((i % 2) == 0 && (j % 2) == 0) || ((i % 2) != 0 && (j % 2) != 0)) {
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

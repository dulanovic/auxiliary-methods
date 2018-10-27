public class PrintPerLine {

    private PrintPerLine() {}

    public static void print(int start, int end, int perLine) {
        for (int i = start; i <= end; i += perLine) {
            for (int j = i; j < i + perLine && j <= end; j++) {
                System.out.printf("%s ", j);
            }
            System.out.println();
        }
    }

}

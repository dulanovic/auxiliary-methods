public class LFSR {

    private LFSR() {}

    public static boolean[] generate(int[] seed, int tap) {
        if (tap >= seed.length - 1) {
            System.err.println("Tap must not be leftmost bit or greater than register size!!!");
            return null;
        }
        int leftmost = seed.length - 1;
        int max = ((int) Math.pow(2, seed.length)) - 1;
        boolean[] sequence = new boolean[max];
        for (int i = 0; i < max; i++) {
            sequence[i] = (seed[leftmost] ^ seed[tap]) == 1;
            for (int j = leftmost; j > 0; j--) {
                seed[j] = seed[j - 1];
            }
            seed[0] = sequence[i] ? 1 : 0;
        }
        /* System.out.println("GENERATED (PSEUDO)RANDOM SEQUENCE:");
        for (int i = 0; i < max; i++) {
            System.out.printf("%d", sequence[i] ? 1 : 0);
            if ((i + 1) % 100 == 0) {
                System.out.println();
            }
        } */
        return sequence;
    }
}

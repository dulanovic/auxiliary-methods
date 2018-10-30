package api;

public class GamblersRuin {

    private GamblersRuin() {}

    public static void simulate(int stake, int goal, int trials) {
        int bets = 0, wins = 0;
        for (int i = 0; i < trials; i++) {
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) {
                    cash++;
                } else {
                    cash--;
                }
                if (cash == goal) {
                    wins++;
                }
                System.out.printf("bets ---> %d, cash ---> %d\n", bets, cash);
            }
            System.out.printf("<<<--------- TRIAL OVER!!! --------->>>\nNumber of wins ---> %d after %d trials\n", wins, i + 1);
        }
        System.out.printf("Total wins ---> %d out of %d trials. Percent of games won ---> %f\n", wins, trials, 100.0 * wins / trials);
        System.out.printf("Average number of bets per trial ---> %f\n", 1.0 * bets / trials);
    }

}

public class LetsMakeADeal {

    private LetsMakeADeal() {}

    public static void deal(int arg) {
        int trialsSwitch = 0, trialsNoSwitch = 0, winsSwitch = 0, winsNoSwitch = 0;
        for (int i = 0; i < arg; i++) {
            int prize = (int) (3 * Math.random() + 1);
            int choice = (int) (3 * Math.random() + 1);
            int reveal = -1;
            do {
                reveal = (int) (3 * Math.random() + 1);
            } while (reveal == choice || reveal == prize);
            int remaining = 1 + 2 + 3 - choice - reveal;
            if (Math.random() < 0.5) {
                choice = remaining;
                trialsSwitch++;
                if (choice == prize) {
                    winsSwitch++;
                }
            } else {
                trialsNoSwitch++;
                if (choice == prize) {
                    winsNoSwitch++;
                }
            }
        }
        System.out.printf("Total trials ---> %d:\n\tWithout switch: trials ---> %d, wins ---> %d, percentage ---> %f\n\tWith switch: trials ---> %d, wins ---> %d, percentage ---> %f\n", arg, trialsSwitch, winsSwitch, 1.0 * winsSwitch / trialsSwitch, trialsNoSwitch, winsNoSwitch, 1.0 * winsNoSwitch / trialsNoSwitch);
    }

}

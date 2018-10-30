package api;

public class Hello {

    public Hello(int number) {
        for (int i = 1; i <= number; i++) {
            String hello = String.valueOf(i);
            int remainder10 = i % 10, remainder100 = i % 100;
            if (remainder100 == 11 || remainder100 == 12 || remainder100 == 13) {
                hello += "th";
            } else if (remainder10 == 1) {
                hello += "st";
            } else if (remainder10 == 2) {
                hello += "nd";
            } else if (remainder10 == 3) {
                hello += "rd";
            } else {
                hello += "th";
            }
            hello += " api.Hello!!!";
            System.out.printf("%s\n", hello);
        }
    }

}

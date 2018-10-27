public class Binary {

    private Binary() {}

    public static String convert(int number) {
        String binary = "";
        int power = 1;
        while (power <= number / 2) {
            power *= 2;
        }
        while (power > 0) {
            if (number < power) {
                binary += 0;
            } else {
                binary += 1;
                number -= power;
            }
            power /= 2;
        }
        return binary;
    }

    public static String convert(int number, int base) {
        if (number == 0) {
            return "0";
        }
        char[] additionalChars = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        String output = "";
        while (number > 0) {
            int remainder = number % base;
            if (remainder > 9) {
                output = additionalChars[remainder - 10] + output;
            } else {
                output = remainder + output;
            }
            number /= base;
        }
        return output;
    }

}

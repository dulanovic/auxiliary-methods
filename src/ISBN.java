public class ISBN {

    private ISBN() {}

    private static void generateChecksum11(String isbn9) {
        int sum = 0, coefficient = 2;
        for (int i = 0; i < isbn9.length(); i++) {
            char value = isbn9.charAt(isbn9.length() - i - 1);
            if (value == '-') {
                continue;
            }
            sum += coefficient * Character.getNumericValue(value);
            coefficient++;
        }
        int d10 = 11 - (sum % 11);
        if (d10 != 10) {
            System.out.printf("10-digit ISBN number ---> %s-%d\n", isbn9, d10);
        } else {
            System.out.printf("10-digit ISBN number ---> %s-X\n", isbn9);
        }
    }

}

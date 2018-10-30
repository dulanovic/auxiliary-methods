package api;

public class RGBToCMYK {

    private RGBToCMYK() {}

    public static double[] RGBToCMYK(int red, int green, int blue) {
        if (red == 0 && green == 0 && blue == 0) {
            return new double[]{0.0, 0.0, 0.0, 1.0};
        }
        double MAX_VAL = 255.0;
        int max = Math.max(red, green);
        max = Math.max(max, blue);
        double white = max / MAX_VAL;
        double cyan = (white - (red / MAX_VAL)) / white;
        double magenta = (white - (green / MAX_VAL)) / white;
        double yellow = (white - (blue / MAX_VAL)) / white;
        double black = 1.0 - white;
        return new double[]{cyan, magenta, yellow, black};
    }
}

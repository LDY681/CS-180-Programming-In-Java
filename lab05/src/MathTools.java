/**
 * CS180 - LAB 05 - MathTools
 * All about mathtools
 *
 * @author Liu Dayu
 * @version 1 2/9/2016
 */
public class MathTools {
    public static double absoluteValue(double n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }

    public static double power(double base, int exponent) {
        double pow = 1;
        if (exponent == 0) {
            return 1;
        }

        if (exponent < 0) {
            for (int i = 0; i < absoluteValue(exponent); i++) {
                pow = pow * base;
            }
            return 1 / pow;
        }

        for (int i = 0; i < exponent; i++) {
            pow = pow * base;
        }
        return pow;
    }

    public static double nthRoot(double value, int root) {
        double x = value;
        if (x <= 0) {
            return 0;
        }
        double xk = value;
        double n = root;
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            xk = 1 / value;
        }

        double xk1 = 1 / n * ((n - 1) * xk + x / power(xk, root - 1));
        double dx = absoluteValue(xk1 - xk);
        while (dx > 0.000000001) {
            double temp = xk;
            xk = xk1;
            xk1 = temp;
            xk1 = 1 / n * ((n - 1) * xk + x / power(xk, root - 1));
            dx = absoluteValue(xk1 - xk);
        }
        return xk1;
    }

    public static String scientificNotation(double n) {

        int exp = 0;


        while (n > 10) {
            n = n / 10;
            exp++;
        }
        while (n <= 1 && n > 0){
            n = n * 10;
            exp--;
        }

        if (n == 10){
            n = 1.0;
            exp ++;
            return n+" x"+" 10"+" ^ "+exp;
        }
        n = ((int) (n * 1000000)) / 1000000.0;
        return String.format("%f x 10 ^ %d",n,exp);
    }
}

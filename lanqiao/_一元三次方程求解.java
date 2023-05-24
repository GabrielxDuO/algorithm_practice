import java.util.*;
import java.io.*;

public class _一元三次方程求解 {
    static final double eps = 1e-4;
    static double a, b, c, d;

    static double f(double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }

    static double search(double l, double r, int dir) {
        while (r - l > eps) {
            double m = (l + r) / 2;
            if (f(m) * dir > 0) r = m;
            else l = m;
        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        d = in.nextDouble();
        for (double i = -100; i < 100; i += 0.99) {
            double x1 = i, x2 = i + 0.99;
            double fx1 = f(x1), fx2 = f(x2);
            if (fx1 * fx2 < 0) {
                System.out.printf("%.2f ", search(x1, x2, fx1 < fx2 ? 1 : -1));
            }
        }
    }
}

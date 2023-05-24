import java.util.*;
import java.io.*;

public class P_比例简化 {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), l = in.nextInt();
        double r = a * 1.0 / b;
        double mn = 1e6;
        int aa = 0, bb = 0;
        for (int i = 0; i <= l; ++i) {
            for (int j = 0; j <= l; ++j) {
                if (gcd(i, j) != 1) continue;
                double rr = i * 1.0 / j;
                if (rr < r) continue;
                if (rr - r < mn) {
                    mn = rr - r;
                    aa = i; bb = j;
                }
            }
        }
        System.out.println(aa + " " + bb);
    }
}

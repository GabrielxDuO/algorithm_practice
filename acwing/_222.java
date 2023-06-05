import java.util.*;
import java.io.*;

public class _222 {
    static long x, y;

    static long exgcd(long a, long b) {
        if (b == 0) {
            x = 1; y = 0;
            return a;
        }
        long d = exgcd(b, a % b);
        long t = x;
        x = y;
        y = t - a / b * y;
        return d;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        int m = in.nextInt(), n = in.nextInt();
        int L = in.nextInt();
        long d = exgcd(m - n, L);
        if ((b - a) % d != 0) {
            System.out.println("Impossible");
            return;
        }
        long x0 = x * (b - a) / d;
        long t = Math.abs(L / d);
        System.out.println((x0 % t + t) % t);
    }
}

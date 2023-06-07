import java.util.*;
import java.io.*;

public class _98 {
    static int t;
    static int N;
    static long A, B;

    static long[] get(long n, long k) {
        if (n == 0) return new long[]{0, 0};
        long a = 1L << (n - 1);
        long sz = a * a;
        long[] pos = get(n - 1, k % sz);
        long x = pos[0], y = pos[1];
        long belong = k / sz;
        if (belong == 0) return new long[]{y, x};
        else if (belong == 1) return new long[]{x, y + a};
        else if (belong == 2) return new long[]{x + a, y + a};
        else return new long[]{a + a - y - 1, a - x - 1};
    }

    static double getDist(long[] a, long[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        while (t-- > 0) {
            N = in.nextInt();
            A = in.nextLong(); B = in.nextLong();
            --A; --B;
            System.out.printf("%.0f\n", 10 * getDist(get(N, A), get(N, B)));
        }
    }
}

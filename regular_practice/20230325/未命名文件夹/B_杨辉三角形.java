import java.util.*;
import java.io.*;

public class Main {
    static int n;

    static long C(long a, long b) {
        long res = 1L;
        for (long i = a, j = 1; j <= b; --i, ++j) {
            res = res * i / j;
            if (res > n) break;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int k = 16; k > 0; --k) {
            long l = 2 * k, r = n;
            while (l < r) {
                long m = l + r >> 1;
                if (C(m, k) >= n) r = m;
                else l = m + 1;
            }
            if (C(l, k) == n) {
                System.out.println(r * (r + 1) / 2 + k + 1);
                return;
            }
        }
    }
}

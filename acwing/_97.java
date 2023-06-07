import java.util.*;
import java.io.*;

public class _97 {
    static final int MOD = 9901;
    static int a, b;

    static long pf(int n) {
        long res = 1L;
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) {
                int s = 0;
                while (n % x == 0) {
                    ++s;
                    n /= x;
                }
                res = res * sum(x, 1L * b * s + 1) % MOD;
            }
        }
        if (n > 1) res = res * sum(n, b + 1) % MOD;
        if (n == 0) res = 0;
        return res;
    }

    static long kasumi(long a, long b) {
        long c = 1;
        while (b > 0) {
            if ((b & 1) != 0) c = (c * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return c;
    }

    static long sum(int p, long k) {
        if (k == 1) return 1;
        if ((k & 1) == 1) return (sum(p, k - 1) + kasumi(p, k - 1)) % MOD;
        else return (kasumi(p, k / 2) + 1) * sum(p, k / 2) % MOD;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); a = (int) in.nval;
        in.nextToken(); b = (int) in.nval;
        System.out.println(pf(a));
    }
}

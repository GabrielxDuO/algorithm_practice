import java.util.*;
import java.io.*;

public class _质数拆分 {
    static int n = 2019;
    static int[] primes = new int[n];
    static int cnt;
    static boolean[] np = new boolean[n + 1];
    static {
        for (int x = 2; x <= n; ++x) {
            if (!np[x]) primes[cnt++] = x;
            for (int i = 0; primes[i] <= n / x; ++i) {
                np[primes[i] * x] = true;
                if (x % primes[i] == 0) break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 0; i < cnt; ++i) {
            for (int j = n; j >= primes[i]; --j) {
                f[j] += f[j - primes[i]];
            }
        }
        System.out.println(f[n]);
    }
}

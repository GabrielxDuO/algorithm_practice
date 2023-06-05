import java.util.*;
import java.io.*;

public class _1294 {
    static final int N = (int) 1e6 + 10,  MOD = (int) 1e9 + 7;
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] np = new boolean[N];

    static void sieve(int n) {
        for (int x = 2; x <= n; ++x) {
            if (!np[x]) primes[cnt++] = x;
            for (int i = 0; primes[i] <= n / x; ++i) {
                np[primes[i] * x] = true;
                if (x % primes[i] == 0) break;
            }
        }
    }

    static int count(int n, int p) {
        int res = 0;
        while (n > 0) res += n /= p;
        return res;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        sieve(n);
        long ans = 1L;
        for (int i = 0; i < cnt; ++i) {
            ans = ans * (2 * count(n, primes[i]) + 1) % MOD;
        }
        System.out.println(ans);
    }
}

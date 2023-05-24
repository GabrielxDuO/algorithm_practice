import java.util.*;
import java.io.*;

public class _Torry的困惑 {
    static final int MOD = 50000;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = (int) (2 * n * Math.log(n) + 10);
        int[] primes = new int[m];
        int cnt = 0;
        boolean[] np = new boolean[m + 1];
        for (int x = 2; x <= m; ++x) {
            if (!np[x]) primes[cnt++] = x;
            if (cnt == n) break;
            for (int i = 0; primes[i] <= m / x; ++i) {
                np[primes[i] * x] = true;
                if (x % primes[i] == 0) break;
            }
        }
        long ans = 1L;
        for (int i = 0; i < cnt; ++i) {
            ans = (ans * primes[i]) % MOD;
        }
        System.out.println(ans);
    }
}

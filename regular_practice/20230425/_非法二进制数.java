import java.util.*;
import java.io.*;

public class _非法二进制数 {
    static final int MOD = (int) 1e9 + 7;

    static long qmi(long base, long exp, long mod) {
        long res = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] f = new long[n + 1][2];
        f[1][0] = f[1][1] = 1;
        for (int i = 2; i <= n; ++i) {
            f[i][0] = (f[i - 1][0] + f[i - 1][1]) % MOD;
            f[i][1] = f[i - 1][0];
        }
        System.out.println(((qmi(2, n, MOD) - f[n][0] - f[n][1]) % MOD + MOD) % MOD);
    }
}

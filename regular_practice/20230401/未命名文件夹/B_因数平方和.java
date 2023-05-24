import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = (int) 1e9 + 7;
    static final int INV = (int) qmi(6, MOD - 2);

    static long qmi(long base, long exp) {
        long res = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    static long s(long n) {
        return n * (n + 1) % MOD * (2 * n + 1) % MOD * INV % MOD;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in); int n = in.nextInt();
        long ans = 0L;
        int l, r;
        for (l = 1; l <= n; l = r + 1) {
            r = n / (n / l);
            ans = (ans + (n / l * (s(r) - s(l - 1)) % MOD + MOD) % MOD) % MOD;
        }
        System.out.println(ans);
    }
}

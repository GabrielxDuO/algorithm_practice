import java.util.*;
import java.io.*;

public class _回路计数 {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void solve() {
        int n = 21, m = 1 << n;
        long[][] f = new long[m][n];
        f[1][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (((1 << j) & i) == 0) continue;
                for (int k = 0; k < n; ++k) {
                    int prev = i - (1 << j);
                    if (((1 << k) & prev) == 0) continue;
                    if (gcd(k + 1, j + 1) == 1) f[i][j] += f[prev][k];
                }
            }
        }
        long ans = 0L;
        for (int i = 1; i < n; ++i) ans += f[m - 1][i];
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        // solve();
        System.out.println("881012367360");
    }
}

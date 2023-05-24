import java.util.*;
import java.io.*;

public class Main {
    static int n = 21, m = 1 << n;
    static boolean[][] g = new boolean[n][n];

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        // for (int i = 1; i <= n; ++i) {
        //     for (int j = 1; j <= n; ++j) {
        //         if (gcd(i, j) == 1) g[i - 1][j - 1] = g[j - 1][i - 1] = true;
        //     }
        // }
        // long[][] dp = new long[m][n];
        // dp[1][0] = 1;
        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j) {
        //         if ((i & (1 << j)) == 0) continue;
        //         int prev = i - (1 << j);
        //         for (int k = 0; k < n; ++k) {
        //             if (g[j][k] && (prev & (1 << k)) != 0) {
        //                 dp[i][j] += dp[prev][k];
        //             }
        //         }
        //     }
        // }
        // long cnt = 0;
        // for (int i = 1; i < n; ++i) cnt += dp[m - 1][i];
        // System.out.println(cnt);
        System.out.println(881012367360L);
    }
}

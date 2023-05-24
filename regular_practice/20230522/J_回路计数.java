import java.util.*;
import java.io.*;

public class J_回路计数 {
    static int n = 21, m = 1 << n;
    static boolean[][] g = new boolean[n][n];
    static long[][] f = new long[m][n];

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        // for (int i = 0; i < n; ++i) {
        //     for (int j = i; j < n; ++j) {
        //         if (gcd(i + 1, j + 1) == 1) g[i][j] = g[j][i] = true;
        //     }
        // }
        // f[1][0] = 1L;
        // for (int s = 0; s < m; ++s) {
        //     for (int u = 0; u < n; ++u) {
        //         if ((s & 1 << u) == 0) continue;
        //         int prev = s - (1 << u);
        //         for (int v = 0; v < n; ++v) {
        //             if (!g[u][v] || (prev & 1 << v) == 0) continue;
        //             f[s][u] += f[prev][v];
        //         }
        //     }
        // }
        // long cnt = 0L;
        // for (int i = 0; i < n; ++i) cnt += f[m - 1][i];
        // System.out.println(cnt); // 881012367360
        System.out.println("881012367360");
    }
}

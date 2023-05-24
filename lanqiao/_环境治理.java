import java.util.*;
import java.io.*;

public class _环境治理 {
    static final int INF = 0x3f3f3f3f;
    static int n, q;
    static int[][] g, lim, dists;

    static void floyd() {
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
                }
            }
        }
    }

    static boolean check(int m) {
        for (int i = 1; i <= n; ++i) dists[i] = g[i].clone();
        int a = m / n, b = m % n;
        for (int i = 1; i <= n; ++i) {
            int rdc1 = a + (i <= b ? 1 : 0);
            for (int j = i + 1; j <= n; ++j) {
                int rdc2 = a + (j <= b ? 1 : 0);
                dists[i][j] = dists[j][i] = Math.max(g[i][j] - rdc1 - rdc2, lim[i][j]);
            }
        }
        floyd();
        int p = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if ((p += dists[i][j]) > q) return false;
            }
        }
        return p <= q;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        q = (int) in.nval;
        g = new int[n + 1][n + 1];
        lim = new int[n + 1][n + 1];
        dists = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                in.nextToken();
                g[i][j] = g[j][i] = (int) in.nval;
            }
        }
        int mx = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                in.nextToken();
                lim[i][j] = lim[j][i] = (int) in.nval;
                mx = Math.max(mx, Math.abs(g[i][j] - lim[i][j]));
            }
        }
        for (int i = 0; i <= mx * n; ++i) {
            if (check(i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
        // int l = 0, r = mx * n;
        // while (l < r) {
        //     int m = l + (r - l >> 1);
        //     if (check(m)) r = m;
        //     else l = m + 1;
        // }
        // System.out.println(check(l) ? l : -1);
    }
}

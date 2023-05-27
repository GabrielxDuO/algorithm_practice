import java.util.*;
import java.io.*;

public class T_环境治理 {
    static final int INF = 0x3f3f3f3f;
    static int n, q;
    static int[][] g, L, d;

    static int floyd() {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res += d[i][j];
            }
        }
        return res;
    }

    static boolean check(int m) {
        for (int i = 0; i < n; ++i) d[i] = g[i].clone();
        int a = (m - 1) / n, b = (m - 1) % n;
        for (int i = 0; i < n; ++i) {
            int d1 = a + (i <= b ? 1 : 0);
            for (int j = 0; j < n; ++j) {
                int d2 = a + (j <= b ? 1 : 0);
                d[i][j] = d[j][i] = Math.max(g[i][j] - d1 - d2, L[i][j]);
            }
        }
        return floyd() <= q;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); q = (int) in.nval;
        g = new int[n][n];
        L = new int[n][n];
        d = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                in.nextToken(); g[i][j] = (int) in.nval;
            }
        }
        int l = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                in.nextToken(); L[i][j] = (int) in.nval;
                r = Math.max(r, g[i][j] - L[i][j]);
            }
        }
        r *= n;
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        System.out.println(check(l) ? l : -1);
    }
}

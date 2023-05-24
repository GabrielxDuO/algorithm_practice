import java.util.*;
import java.io.*;

public class _城邦 {
    static final int N = 2030, INF = 0x3f3f3f3f;
    static int n = 2021;
    static int[][] g = new int[N][N];
    static boolean[] vis = new boolean[N];
    static int[] dists = new int[N];

    static int prim() {
        Arrays.fill(dists, INF);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int mn = -1;
            for (int j = 1; j <= n; ++j) {
                if (!vis[j] && (mn == -1 || dists[j] < dists[mn])) mn = j;
            }
            if (i != 0) {
                if (dists[mn] == INF) return INF;
                res += dists[mn];
            }
            vis[mn] = true;
            for (int j = 1; j <= n; ++j) dists[j] = Math.min(dists[j], g[j][mn]);
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j) {
                    g[i][i] = INF;
                    continue;
                }
                int x = i, y = j, w = 0;
                while (x > 0 || y > 0) {
                    int a = x % 10, b = y % 10;
                    if (a != b) w += a + b;
                    x /= 10;
                    y /= 10;
                }
                g[i][j] = g[j][i] = w;
            }
        }
        System.out.println(prim());
    }
}

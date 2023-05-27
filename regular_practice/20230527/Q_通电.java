import java.util.*;
import java.io.*;

public class Q_通电 {
    static final int INF = 0x3f3f3f3f;
    static int n;
    static int[][] poses;
    static double[][] g;

    static double getDist(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2)) +
            Math.pow(a[2] - b[2], 2);
    }

    static double prim() {
        double[] dists = new double[n + 1];
        Arrays.fill(dists, INF);
        boolean[] vis = new boolean[n + 1];
        double res = 0.0;
        for (int i = 0; i < n; ++i) {
            int mn = -1;
            for (int j = 1; j <= n; ++j) {
                if (!vis[j] && (mn == -1 || dists[j] < dists[mn])) mn = j;
            }
            if (i > 0) {
                if (dists[mn] == INF) return -1;
                res += dists[mn];
            }
            vis[mn] = true;
            for (int j = 1; j <= n; ++j) {
                dists[j] = Math.min(dists[j], g[mn][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        poses = new int[n + 1][3];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); poses[i][0] = (int) in.nval;
            in.nextToken(); poses[i][1] = (int) in.nval;
            in.nextToken(); poses[i][2] = (int) in.nval;
        }
        g = new double[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                g[i][j] = g[j][i] = getDist(poses[i], poses[j]);
            }
        }
        System.out.printf("%.2f", prim());
    }
}

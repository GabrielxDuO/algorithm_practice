import java.util.*;
import java.io.*;

public class _通电 {
    static int n;
    static int[][] poses;

    static double getDist(int a, int b) {
        return Math.sqrt(Math.pow(poses[a][0] - poses[b][0], 2) + 
            Math.pow(poses[a][1] - poses[b][1], 2)) + 
            Math.pow(poses[a][2] - poses[b][2], 2);
    }

    static double prim() {
        double[] dists = new double[n + 1];
        Arrays.fill(dists, Double.MAX_VALUE);
        boolean[] vis = new boolean[n + 1];
        double res = 0.0;
        for (int i = 0; i < n; ++i) {
            int mn = -1;
            for (int j = 1; j <= n; ++j) {
                if (!vis[j] && (mn == -1 || dists[j] < dists[mn])) mn = j;
            }
            if (i > 0) {
                if (dists[mn] == Double.MAX_VALUE) return Double.MAX_VALUE;
                res += dists[mn];
            }
            for (int j = 1; j <= n; ++j) {
                dists[j] = Math.min(dists[j], getDist(mn, j));
            }
            vis[mn] = true;
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
        System.out.printf("%.2f\n", prim());
    }
}

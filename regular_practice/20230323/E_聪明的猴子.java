import java.util.*;
import java.io.*;

public class E_聪明的猴子 {
    static final int INF = 0x3f3f3f3f;
    static int n;
    static int[][] poses;

    static int getSquDist(int u, int v) {
        int dx = poses[u][0] - poses[v][0];
        int dy = poses[u][1] - poses[v][1];
        return dx * dx + dy * dy;
    }

    static int prim() {
        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);
        boolean[] vis = new boolean[n + 1];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            int mn = -1;
            for (int j = 1; j <= n; ++j) {
                if (!vis[j] && (mn == -1 || dists[j] < dists[mn])) mn = j;
            }
            if (i > 0) {
                if (dists[mn] == INF) return -1;
                mx = Math.max(mx, dists[mn]);
            }
            for (int j = 1; j <= n; ++j) {
                dists[j] = Math.min(dists[j], getSquDist(j, mn));
            }
            vis[mn] = true;
        }
        return mx;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        int[] ms = new int[m];
        for (int i = 0; i < m; ++i) {
            in.nextToken();
            ms[i] = (int) in.nval;
        }
        in.nextToken();
        n = (int) in.nval;
        poses = new int[n + 1][2];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            poses[i][0] = (int) in.nval;
            in.nextToken();
            poses[i][1] = (int) in.nval;
        }
        int mx = prim();
        int ans = 0;
        for (int mk : ms) {
            if (mk * mk >= mx) ++ans;
        }
        System.out.println(ans);
    }
}

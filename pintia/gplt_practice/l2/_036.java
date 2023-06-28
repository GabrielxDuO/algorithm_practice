import java.util.*;
import java.io.*;

public class _036 {
    static final int INF = 0x3f3f3f3f;
    static int n, m, k;
    static int[][] g;
    static boolean[] vis;
    static int[] path;
    static int mn = INF, mn_idx, cnt;

    static boolean check(int t) {
        int cost = 0;
        for (int i = 0; i < n; ++i)
            cost += g[path[i]][path[i + 1]];
        cost += g[path[n]][0];
        if (cost < mn) {
            mn = cost;
            mn_idx = t;
        }
        return cost < INF;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        g = new int[n + 1][n + 1];
        vis = new boolean[n + 1];
        path = new int[n + 1];
        for (int[] arr : g) Arrays.fill(arr, INF);
        while (m-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            in.nextToken(); int c = (int) in.nval;
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        in.nextToken(); k = (int) in.nval;
        for (int i = 1; i <= k; ++i) {
            in.nextToken(); int nn = (int) in.nval;
            if (nn != n) {
                while (nn-- > 0) in.nextToken();
                continue;
            }
            Arrays.fill(vis, false);
            vis[0] = true;
            boolean invalid = false;
            for (int j = 1; j <= n; ++j) {
                in.nextToken(); path[j] =  (int) in.nval;
                if (vis[path[j]]) invalid = true;
                else vis[path[j]] = true;
            }
            if (invalid || g[0][path[1]] == INF || g[path[n]][0] == INF || !check(i))
                continue;
            ++cnt;
        }
        System.out.printf("%d\n%d %d\n", cnt, mn_idx, mn);
    }
}

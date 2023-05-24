import java.util.*;
import java.io.*;

public class _网络寻路 {
    static int n, m;
    static int[] h, e, ne;
    static int idx;
    static boolean[] vis;
    static int ans;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u, int cnt, int src) {
        if (cnt == 4) {
            ++ans;
            return;
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (cnt != 3 && v == src) continue;
            if (!vis[v] || (cnt == 3 && v == src)) {
                vis[v] = true;
                dfs(v, cnt + 1, src);
                vis[v] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[m * 2];
        ne = new int[m * 2];
        while (m-- > 0) {
            in.nextToken(); int u = (int) in.nval;
            in.nextToken(); int v = (int) in.nval;
            add(u, v); add(v, u);
        }
        vis = new boolean[n + 1];
        for (int u = 1; u <= n; ++u) dfs(u, 1, u);
        System.out.println(ans);
    }
}
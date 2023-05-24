import java.util.*;
import java.io.*;

public class _蓝桥舞会 {
    static int n;
    static int[] happy;
    static int[] h, e, ne;
    static int idx;
    static int[][] f;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u) {
        f[u][1] = happy[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            dfs(v);
            f[u][0] += Math.max(f[v][0], f[v][1]);
            f[u][1] += f[v][0];
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        happy = new int[n + 1];
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[n - 1];
        ne = new int[n - 1];
        boolean[] hasBoss = new boolean[n + 1];
        for (int u = 1; u <= n; ++u) {
            in.nextToken(); happy[u] = (int) in.nval;
        }
        for (int i = 0; i < n - 1; ++i) {
            in.nextToken(); int u = (int) in.nval;
            in.nextToken(); int v = (int) in.nval;
            add(v, u);
            hasBoss[u] = true;
        }
        f = new int[n + 1][2];
        for (int u = 1; u <= n; ++u) {
            if (!hasBoss[u]) {
                dfs(u);
                System.out.println(Math.max(f[u][0], f[u][1]));
                break;
            }
        }
    }
}

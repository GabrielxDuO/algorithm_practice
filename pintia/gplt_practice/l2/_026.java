import java.util.*;
import java.io.*;

public class _026 {
    static int n;
    static int[] h, e, ne;
    static int idx, root;
    static int[] w;
    static int mx;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u, int dep) {
        mx = Math.max(mx, dep);
        w[u] = dep;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            dfs(v, dep + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); n = (int) in.nval;
        h = new int[n + 10];
        e = new int[n + 10];
        ne = new int[n + 10];
        w = new int[n + 10];
        Arrays.fill(h, -1);
        for (int u = 1; u <= n; ++u) {
            in.nextToken(); int v = (int) in.nval;
            if (v != -1) add(v, u);
            else root = u;
        }
        dfs(root, 1);
        StringBuilder ans = new StringBuilder();
        ans.append(mx).append('\n');
        boolean first = true;
        for (int u = 1; u <= n; ++u) {
            if (w[u] == mx) ans.append(u).append(' ');
        }
        out.println(ans.substring(0, ans.length() - 1));
        out.flush();
        out.close();
    }
}

import java.io.*;
import java.util.*;

public class _023 {
    static final int N = 510, M = N * N * 2;
    static int V, E, K, n;
    static int[] color = new int[N];
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx;
    static boolean[] vis = new boolean[N];
    static Set<Integer> st = new HashSet<>();

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean dfs(int u) {
        int c = color[u];
        vis[u] = true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (color[v] == c)
                return false;
            if (!vis[v] && !dfs(v))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        V = (int) in.nval;
        in.nextToken();
        E = (int) in.nval;
        in.nextToken();
        K = (int) in.nval;
        n = 0;
        Arrays.fill(h, -1);
        while (E-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            add(a, b);
            add(b, a);
        }
        in.nextToken();
        n = (int) in.nval;
        outer: while (n-- > 0) {
            st.clear();
            for (int i = 1; i <= V; ++i) {
                in.nextToken();
                color[i] = (int) in.nval;
                st.add(color[i]);
            }
            if (st.size() != K) {
                out.println("No");
                continue;
            }
            Arrays.fill(vis, false);
            for (int u = 1; u <= V; ++u) {
                if (!dfs(u)) {
                    out.println("No");
                    continue outer;
                }
            }
            out.println("Yes");
        }
        out.flush();
    }
}

import java.util.*;
import java.io.*;

public class K_左孩子右兄弟 {
    static int n;
    static int[] h, e, ne;
    static int idx;

    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    static int dfs(int u) {
        int mx = 0, cnt = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            mx = Math.max(mx, dfs(v));
            ++cnt;
        }
        return mx + cnt;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[n];
        ne = new int[n];
        for (int u = 2; u <= n; ++u) {
            in.nextToken(); int p = (int) in.nval;
            add(p, u);
        }
        System.out.println(dfs(1));
    }
}

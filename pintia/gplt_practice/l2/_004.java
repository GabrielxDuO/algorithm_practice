import java.io.*;
import java.util.*;

public class _004 {
    static int N = 1010;
    static int n;
    static int[] pre = new int[N], post = new int[N];
    static int idx;

    static void dfs(int l, int r, boolean type) {
        if (l > r) return;
        int u = l, lc = r, rc = l + 1;
        while (lc > l && (pre[lc] >= pre[u]) == type) --lc;
        while (rc <= r && (pre[rc] < pre[u]) == type) ++rc;
        if (lc + 1 != rc) return;
        dfs(u + 1, lc, type);
        dfs(rc, r, type);
        post[++idx] = pre[u];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            pre[i] = (int) in.nval;
        }
        dfs(1, n, true);
        if (idx != n) {
            idx = 0;
            dfs(1, n, false);
        }
        if (idx != n) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 1; i <= n; ++i) {
                System.out.printf("%d", post[i]);
                System.out.print(i == n ? "\n" : " ");
            }
        }
    }
}

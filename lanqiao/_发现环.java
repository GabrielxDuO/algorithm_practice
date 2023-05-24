import java.util.*;
import java.io.*;

public class _发现环 {
    static int n;
    static int[] roots;
    static int[] h, e, ne;
    static int idx;
    static int st, ed;
    static boolean[] vis;
    static int[] ans;
    static int cnt;

    static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }

    static void union(int a, int b) {
        roots[find(a)] = find(b);
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u) {
        if (u == ed) {
            Arrays.sort(ans, 0, cnt);
            for (int i = 0; i < cnt; ++i) System.out.print(ans[i] + " ");
            System.out.println();
            return;
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (vis[v]) continue;
            vis[v] = true;
            ans[cnt++] = v;
            dfs(v);
            vis[v] = false;
            --cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        roots = new int[n + 1];
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[n * 2];
        ne = new int[n * 2];
        for (int i = 1; i <= n; ++i) roots[i] = i;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            if (find(a) != find(b)) {
                union(a, b);
                add(a, b); add(b, a);
            }  else {
                st = a; ed = b;
            }
        }
        ans = new int[n];
        vis = new boolean[n + 1];
        vis[st] = true;
        ans[cnt++] = st;
        dfs(st);
    }
}

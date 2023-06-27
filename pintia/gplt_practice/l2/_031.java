import java.util.*;
import java.io.*;

public class _031 {
    static int n, k;
    static int[] h, e, ne;
    static int idx;
    static boolean[] ind;
    static int root;
    static int[] que;
    static int hh, tt = -1;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int bfs(int u) {
        que = new int[n + 1];
        que[++tt] = u;
        int res = -1;
        while (hh <= tt) {
            int sz = tt - hh + 1;
            while (sz-- > 0) {
                u = que[hh++];
                if (h[u] == -1) res = u;
                for (int i = h[u]; i != -1; i = ne[i]) {
                    int v = e[i];
                    que[++tt] = v;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        h = new int[n + 1];
        e = new int[n + 1];
        ne = new int[n + 1];
        ind = new boolean[n + 1];
        Arrays.fill(h, -1);
        for (int u = 1; u <= n; ++u) {
            in.nextToken(); k = (int) in.nval;
            int v;
            while (k-- > 0) {
                in.nextToken(); v = (int) in.nval;
                add(u, v);
                ind[v] = true;
            }
        }
        for (int i = 1; i <= n; ++i) {
            if (!ind[i]) {
                root = i;
                break;
            }
        }
        System.out.println(bfs(root));
    }
}

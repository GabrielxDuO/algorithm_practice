import java.util.*;
import java.io.*;

public class _164 {
    static int n, m;
    static int[] ind, h, e, ne;
    static int idx;
    static int[] que;
    static int hh, tt = -1;
    static BitSet[] f;

    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    static void topSort() {
        for (int u = 1; u <= n; ++u) {
            if (ind[u] == 0) que[++tt] = u;
        }
        while (hh <= tt) {
            int u = que[hh++];
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (--ind[v] == 0) que[++tt] = v;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        ind = new int[n + 1];
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[m];
        ne = new int[m];
        while (m-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            add(a, b);
            ++ind[b];
        }
        que = new int[n];
        topSort();
        f = new BitSet[n + 1];
        for (int u = 1; u <= n; ++u) f[u] = new BitSet();
        for (int i = n - 1; i >= 0; --i) {
            int u = que[i];
            f[u].set(u, true);
            for (int j = h[u]; j != -1; j = ne[j]) f[u].or(f[e[j]]);
        }
        for (int u = 1; u <= n; ++u) System.out.println(f[u].cardinality());
    }
}

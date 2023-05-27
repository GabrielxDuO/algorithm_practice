import java.util.*;
import java.io.*;

public class S_机房 {
    static final int INF = 0x3f3f3f3f;
    static int n, m;
    static int[] deg;
    static int[] h, e, ne;
    static int idx;
    static int[] dists;
    static boolean[] has;
    static Queue<Integer> que = new LinkedList<>();

    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    static int spfa(int src, int dest) {
        Arrays.fill(dists, INF);
        dists[src] = deg[src];
        que.offer(src);
        has[src] = true;
        while (!que.isEmpty()) {
            int u = que.poll();
            has[u] = false;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (dists[u] + deg[v] < dists[v]) {
                    dists[v] = dists[u] + deg[v];
                    if (!has[v]) {
                        que.offer(v);
                        has[v] = true;
                    }
                }
            }
        }
        return dists[dest] == INF ? -1 : dists[dest];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        deg = new int[n + 1];
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[n * 2];
        ne = new int[n * 2];
        for (int i = 0; i < n - 1; ++i) {
            in.nextToken(); int x = (int) in.nval;
            in.nextToken(); int y = (int) in.nval;
            ++deg[x]; ++deg[y];
            add(x, y); add(y, x);
        }
        dists = new int[n + 1];
        has = new boolean[n + 1];
        while (m-- > 0) {
            in.nextToken(); int u = (int) in.nval;
            in.nextToken(); int v = (int) in.nval;
            System.out.println(spfa(u, v));
        }
    }
}

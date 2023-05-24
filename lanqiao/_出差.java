import java.util.*;
import java.io.*;

public class _出差 {
    static final int INF = 0x3f3f3f3f;
    static int n, m;
    static int[] c;
    static int[] h, e, w, ne;
    static int idx;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    // static int spfa(int src, int dest) {
    //     int[] dists = new int[n + 1];
    //     Arrays.fill(dists, INF);
    //     boolean[] has = new boolean[n + 1];
    //     Queue<Integer> que = new LinkedList<>();
    //     dists[src] = 0;
    //     que.offer(src);
    //     has[src] = true;
    //     while (!que.isEmpty()) {
    //         int u = que.poll();
    //         has[u] = false;
    //         StringBuilder s = new StringBuilder();
    //         for (int i = h[u]; i != -1; i = ne[i]) {
    //             int v = e[i];
    //             int nd = dists[u] + w[i] + c[v];
    //             if (nd < dists[v]) {
    //                 dists[v] = nd;
    //                 if (!has[v]) {
    //                     que.offer(v);
    //                     has[v] = true;
    //                 }
    //             }
    //         }
    //     }
    //     return dists[dest] == INF ? -1 : dists[dest];
    // }

    static int dijkstra(int src, int dest) {
        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);
        boolean[] vis = new boolean[n + 1];
        dists[src] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], mn = curr[1];
            vis[mn] = true;
            for (int i = h[mn]; i != -1; i = ne[i]) {
                int v = e[i];
                int nd = d + w[i] + c[v];
                if (nd < dists[v]) {
                    dists[v] = nd;
                    pq.offer(new int[]{dists[v], v});
                }
            }
        }
        return dists[dest] == INF ? -1 : dists[dest];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        c = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            if (i == n) continue;
            c[i] = (int) in.nval;
        }
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[m * 2];
        w = new int[m * 2];
        ne = new int[m * 2];
        while (m-- > 0) {
            in.nextToken();
            int u = (int) in.nval;
            in.nextToken();
            int v = (int) in.nval;
            in.nextToken();
            int w = (int) in.nval;
            add(u, v, w);
            add(v, u, w);
        }
        // System.out.println(spfa(1, n));
        System.out.println(dijkstra(1, n));
    }
}

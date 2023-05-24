import java.util.*;
import java.io.*;

public class _蓝桥王国 {
    static long INF = 0x3f3f3f3f3f3f3f3fL;
    static int n, m;
    static int[] h, e, w, ne;
    static int idx;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    // static long[] spfa(int src) {
    //     long[] dists = new long[n + 1];
    //     boolean[] has = new boolean[n + 1];
    //     Queue<Integer> que = new LinkedList<>();
    //     Arrays.fill(dists, INF);
    //     dists[src] = 0;
    //     que.offer(src);
    //     has[src] = true;
    //     while (!que.isEmpty()) { 
    //         int u = que.poll();
    //         has[u] = false;
    //         for (int i = h[u]; i != -1; i = ne[i]) {
    //             int v = e[i];
    //             long nd = 1L * dists[u] + w[i];
    //             if (nd < dists[v]) {
    //                 dists[v] = nd;
    //                 if (!has[v]) {
    //                     que.offer(v);
    //                     has[v] = true;
    //                 }
    //             }
    //         }
    //     }
    //     return dists;
    // }

    static long[] dijkstra(int src) {
        long[] dists = new long[n + 1];
        Arrays.fill(dists, INF);
        boolean[] vis = new boolean[n + 1];
        Queue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (a[0] - b[0]));
        dists[src] = 0L;
        pq.offer(new long[]{0L, src});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int mn = (int) curr[1];
            vis[mn] = true;
            for (int i = h[mn]; i != -1; i = ne[i]) {
                int v = e[i];
                if (d + w[i] < dists[v]) {
                    dists[v] = d + w[i];
                    pq.offer(new long[]{dists[v], v});
                }
            }
        }
        return dists;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[m];
        w = new int[m];
        ne = new int[m];
        while (m-- > 0) {
            in.nextToken();
            int u = (int) in.nval;
            in.nextToken();
            int v = (int) in.nval;
            in.nextToken();
            int w = (int) in.nval;
            add(u, v, w);
        }
        // long[] dists = spfa(1);
        long[] dists = dijkstra(1);
        for (int i = 1; i <= n; ++i) System.out.print((dists[i] == INF ? -1 : dists[i]) + " ");
    }
}

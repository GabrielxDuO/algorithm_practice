import java.util.*;
import java.io.*;

public class Main {
    static final long INF = 0x3f3f3f3f3f3f3f3fL;
    static int n, m, s, t;
    static int[] h, r, g, w, e, ne;
    static boolean[] revs;
    static int idx;

    static void add(int u, int v, int a, int b, int c, boolean rev) {
        e[idx] = v;
        g[idx] = a;
        r[idx] = b;
        w[idx] = c;
        revs[idx] = rev;
        ne[idx] = h[u];
        h[u] = idx++;
    }

    static long spfa(int src, int dest) {
        long[] dists = new long[n + 1];
        Arrays.fill(dists, INF);
        dists[src] = 0;
        boolean[] has = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(src);
        has[src] = true;
        while (!que.isEmpty()) {
            int u = que.poll();
            has[u] = false;
            long d = dists[u];
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                long curr = d % (2L * w[i] + r[i] + g[i]);
                long wait;
                if (revs[i]) {
                    if (curr < g[i] + w[i]) wait = 1L * g[i] + w[i] - curr;
                    else if (curr < g[i] + w[i] + r[i]) wait = 0;
                    else wait = 2L * g[i] + r[i] + 3L * w[i] - curr;
                } else {
                    if (curr < g[i]) wait = 0;
                    else wait = 2L * w[i] + g[i] + r[i] - curr;
                }
                long nd = wait + d + w[i];
                if (nd < dists[v]) {
                    dists[v] = nd;
                    if (!has[v]) {
                        que.offer(v);
                        has[v] = true;
                    }
                }
            }
        }
        return dists[dest] == INF ? -1 : dists[dest];
    }

    static long dijkstra(int src, int dest) {
        long[] dists = new long[n + 1];
        Arrays.fill(dists, INF);
        dists[src] = 0;
        Queue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (a[1] - b[1]));
        pq.offer(new long[]{src, 0});
        while (!pq.isEmpty()) {
            long[] front = pq.poll();
            int mn = (int) front[0];
            long d = front[1];
            for (int i = h[mn]; i != -1; i = ne[i]) {
                int v = e[i];
                long curr = d % (2L * w[i] + r[i] + g[i]);
                long wait;
                if (revs[i]) {
                    if (curr < g[i] + w[i]) wait = 1L * g[i] + w[i] - curr;
                    else if (curr < g[i] + w[i] + r[i]) wait = 0;
                    else wait = 2L * g[i] + r[i] + 3L * w[i] - curr;
                } else {
                    if (curr < g[i]) wait = 0;
                    else wait = 2L * w[i] + g[i] + r[i] - curr;
                }
                long nd = wait + d + w[i];
                if (nd < dists[v]) {
                    dists[v] = nd;
                    pq.offer(new long[]{v, nd});
                }
            }
        }
        return dists[dest] == INF ? -1 : dists[dest];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); s = (int) in.nval;
        in.nextToken(); t = (int) in.nval;
        h = new int[n + 1];
        Arrays.fill(h, -1);
        r = new int[m * 2];
        g = new int[m * 2];
        w = new int[m * 2];
        e = new int[m * 2];
        ne = new int[m * 2];
        revs = new boolean[m * 2];
        while (m-- > 0) {
            in.nextToken(); int u = (int) in.nval;
            in.nextToken(); int v = (int) in.nval;
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            in.nextToken(); int c = (int) in.nval;
            add(u, v, a, b, c, false); add(v, u, a, b, c, true);
        }
        System.out.println(dijkstra(s, t));
    }
}

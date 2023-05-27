import java.util.*;
import java.io.*;

public class R_出差 {
    static final int INF = 0x3f3f3f3f;
    static int n, m;
    static int[] h, w1, w2, e, ne;
    static int idx;

    static void add(int a, int b, int c) {
        e[idx] = b; w2[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }

    static int dij(int src, int dest) {
        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);
        dists[src] = 0;
        boolean[] vis = new boolean[n + 1];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int mn = curr[1];
            if (vis[mn]) continue;
            vis[mn] = true;
            int d = curr[0];
            for (int i = h[mn]; i != -1; i = ne[i]) {
                int v = e[i];
                if (d + w1[v] + w2[i] < dists[v]) {
                    dists[v] = d + w1[v] + w2[i];
                    pq.offer(new int[]{dists[v], v});
                }
            }
        }
        return dists[dest] == INF ? -1 : dists[dest];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        h = new int[n + 1];
        Arrays.fill(h, -1);
        w1 = new int[n + 1];
        w2 = new int[m * 2];
        e = new int[m * 2];
        ne = new int[m * 2];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); w1[i] = (int) in.nval;
        }
        w1[n] = 0;
        while (m-- > 0) {
            in.nextToken(); int u = (int) in.nval;
            in.nextToken(); int v = (int) in.nval;
            in.nextToken(); int c = (int) in.nval;
            add(u, v, c); add(v, u, c);
        }
        System.out.println(dij(1, n));
    }
}

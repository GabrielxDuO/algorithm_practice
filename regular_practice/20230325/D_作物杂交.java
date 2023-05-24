import java.util.*;
import java.io.*;

public class D_作物杂交 {
    static final int INF = 0x3f3f3f3f;
    static int n, m, k, t;
    static int[] times, init;
    static int[] h, tog, prod, ne;
    static int idx;
    
    static void add(int a, int b, int c) {
        tog[idx] = b;
        prod[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    
    static int spfa(int dest) {
        int[] dists = new int[n + 1];
        boolean[] has = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        Arrays.fill(dists, INF);
        for (int u : init) {
            dists[u] = 0;
            que.offer(u);
            has[u] = true;
        }
        while (!que.isEmpty()) {
            int u = que.poll();
            has[u] = false;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = tog[i], p = prod[i];
                int cost = Math.max(dists[u], dists[v]) + Math.max(times[u], times[v]);
                if (cost < dists[p]) {
                    dists[p] = cost;
                    if (!has[p]) {
                        que.offer(p);
                        has[p] = true;
                    }
                }
            }
        }
        return dists[dest];
    }
    
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        in.nextToken();
        t = (int) in.nval;
        times = new int[n + 1];
        init = new int[m];
        h = new int[n + 1];
        Arrays.fill(h, -1);
        tog = new int[k * 2];
        prod = new int[k * 2];
        ne = new int[k * 2];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            times[i] = (int) in.nval;
        }
        while (m-- > 0) {
            in.nextToken();
            init[m] = (int) in.nval;
        }
        while (k-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            in.nextToken();
            int c = (int) in.nval;
            add(a, b, c);
            add(b, a, c);
        }
        System.out.println(spfa(t));
    }
}

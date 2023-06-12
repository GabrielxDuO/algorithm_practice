import java.util.*;
import java.io.*;

public class L2_001 {
    static final int INF = 0x3f3f3f3f;
    static int n, m, s, d;
    static int[] w1;
    static int[] h, w2, e, ne;
    static int idx;
    static int[] dists, cnts, nums;
    static boolean[] vis;
    static int[] prevs;

    static void add(int a, int b, int c) {
        e[idx] = b; w2[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }

    static void dij(int src, int dest) {
        dists = new int[n];
        cnts = new int[n];
        nums = new int[n];
        vis = new boolean[n];
        prevs = new int[n];
        Arrays.fill(dists, INF);
        Arrays.fill(prevs, -1);
        dists[src] = 0;
        cnts[src] = 1;
        nums[src] = w1[src];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            int mn = u[1];
            if (vis[mn]) continue;
            vis[mn] = true;
            int d = u[0];
            for (int i = h[mn]; i != -1; i = ne[i]) {
                int v = e[i];
                if (d + w2[i] < dists[v]) {
                    dists[v] = d + w2[i];
                    cnts[v] = cnts[mn];
                    nums[v] = nums[mn] + w1[v];
                    prevs[v] = mn;
                    pq.add(new int[]{dists[v], v});
                } else if (d + w2[i] == dists[v]) {
                    if (nums[mn] + w1[v] > nums[v]) {
                        nums[v] = nums[mn] + w1[v];
                        prevs[v] = mn;
                    }
                    cnts[v] += cnts[mn];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); s = (int) in.nval;
        in.nextToken(); d = (int) in.nval;
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        h = new int[n];
        Arrays.fill(h, -1);
        w1 = new int[n];
        w2 = new int[m * 2];
        e = new int[m * 2];
        ne = new int[m * 2];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); w1[i] = (int) in.nval;
        }
        while (m-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            in.nextToken(); int c = (int) in.nval;
            add(a, b, c); add(b, a, c);
        }
        dij(s, d);
        out.println(cnts[d] + " " + nums[d]);
        StringBuilder path = new StringBuilder();
        while (d != s) {
            path.append(d).append(' ');
            d = prevs[d];
        }
        path.append(s);
        out.println(path.reverse());
        out.flush();
        out.close();
    }
}

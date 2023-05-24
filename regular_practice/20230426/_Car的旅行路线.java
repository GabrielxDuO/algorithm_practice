import java.util.*;
import java.io.*;

public class _Car的旅行路线 {
    static final int INF = 0x3f3f3f3f;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(br);
    static int s, T, A, B;
    static int n, m;
    static int[][] pts;
    static int[] ts;
    static int[] h, e, ne;
    static double[] w;
    static int idx;

    static int getSquDist(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2, dy = y1 - y2;
        return dx * dx + dy * dy;
    }

    static double getDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(getSquDist(x1, y1, x2, y2));
    }

    static void add(int a, int b, double c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int[] getD(int ax, int ay, int bx, int by, int cx, int cy) {
        int squAB = getSquDist(ax, ay, bx, by);
        int squBC = getSquDist(bx, by, cx, cy);
        int squAC = getSquDist(ax, ay, cx, cy);
        if (squAB + squBC == squAC) return new int[]{cx + ax - bx, cy + ay - by, 0};
        else if (squAB + squAC == squBC) return new int[]{ax + bx - ax, cy + by - ay, 0};
        else if (squBC + squAC == squAB) return new int[]{ax + bx - cx, ay + by - cy, 0};
        return null;
    }

    static double spfa(int src, int dest) {
        double[] dists = new double[n + 1];
        Arrays.fill(dists, INF);
        Queue<Integer> que = new LinkedList<>();
        boolean[] has = new boolean[n + 1];
        int st = (src - 1) * 4 + 1, ed = st + 4;
        for (int i = st; i < ed; ++i) {
            dists[i] = 0.0;
            que.offer(i);
            has[i] = true;
        }
        while (!que.isEmpty()) {
            int u = que.poll();
            has[u] = false;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (dists[u] + w[i] < dists[v]) {
                    dists[v] = dists[u] + w[i];
                    if (!has[v]) {
                        que.offer(v);
                        has[v] = true;
                    }
                }
            }
        }
        double mn = INF;
        st = (dest - 1) * 4 + 1; ed = st + 4;
        for (int i = st; i < ed; ++i) mn = Math.min(mn, dists[i]);
        return mn;
    }

    static void solve() throws IOException {
        in.nextToken(); s = (int) in.nval;
        in.nextToken(); T = (int) in.nval;
        in.nextToken(); A = (int) in.nval;
        in.nextToken(); B = (int) in.nval;
        n = s * 4; m = 2 * n * n;
        pts = new int[n + 1][3];
        ts = new int[s + 1];
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[m];
        ne = new int[m];
        w = new double[m];
        for (int i = 1; i <= n; i += 4) {
            int city = i / 4 + 1;
            in.nextToken(); pts[i][0] = (int) in.nval;
            in.nextToken(); pts[i][1] = (int) in.nval;
            in.nextToken(); pts[i + 1][0] = (int) in.nval;
            in.nextToken(); pts[i + 1][1] = (int) in.nval;
            in.nextToken(); pts[i + 2][0] = (int) in.nval;
            in.nextToken(); pts[i + 2][1] = (int) in.nval;
            in.nextToken(); ts[city] = (int) in.nval;
            int[] pos = getD(pts[i][0], pts[i][1], pts[i + 1][0], pts[i + 1][1], pts[i + 2][0], pts[i + 2][1]);
            pts[i + 3] = pos;
            pts[i][2] = pts[i + 1][2] = pts[i + 2][2] = pts[i + 3][2] = city;
        }
        for (int u = 1; u <= n; ++u) {
            int cu = pts[u][2];
            for (int v = 1; v <= n; ++v) {
                double d = getDist(pts[u][0], pts[u][1], pts[v][0], pts[v][1]);
                double w = d * (cu == pts[v][2] ? ts[pts[u][2]] : T);
                add(u, v, w); add(v, u, w);
            }
        }
        System.out.printf("%.1f\n", spfa(A, B));
    }

    public static void main(String[] args) throws IOException {
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) solve();
    }
}

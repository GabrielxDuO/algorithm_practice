import java.util.*;
import java.io.*;

public class _文化之旅 {
    static final int INF = 0x3f3f3f3f;
    static int n, k, m, s, t;
    static int[] cul;
    static boolean[][] rej;
    static int[] h, e, w, ne;
    static int idx;
    static int[] dists;
    static boolean[] went, learnt;
    static int ans = INF;

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void spfa(int src) {
        dists = new int[n + 1];
        Arrays.fill(dists, INF);
        dists[src] = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[] has = new boolean[n + 1];
        que.offer(src);
        has[src] = true;
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
    }

    static boolean check(int u) {
        for (int c = 1; c <= k; ++c) {
            if (learnt[c] && rej[c][cul[u]]) return false;
        }
        return true;
    }

    static void dfs(int u, int d) {
        if (d >= ans) return;
        if (d + dists[u] >= ans) return;
        if (u == s) {
            ans = d;
            return;
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (!went[v] && !learnt[cul[v]] && check(v)) {
                went[v] = learnt[cul[v]] = true;
                dfs(v, d + w[i]);
                went[v] = learnt[cul[v]] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); k = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); s = (int) in.nval;
        in.nextToken(); t = (int) in.nval;
        cul = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); cul[i] = (int) in.nval;
        }
        rej = new boolean[k + 1][k + 1];
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= k; ++j) {
                in.nextToken(); rej[i][j] = (in.nval == 1 ? true : false);
            }
        }
        h = new int[n + 1];
        Arrays.fill(h, -1);
        e = new int[m * 2];
        ne = new int[m * 2];
        w = new int[m * 2];
        while (m-- > 0) {
            in.nextToken(); int u = (int) in.nval;
            in.nextToken(); int v = (int) in.nval;
            in.nextToken(); int w = (int) in.nval;
            add(u, v, w); add(v, u, w);
        }
        spfa(s);
        if (dists[t] == INF) {
            System.out.println(-1);
            return;
        }
        went = new boolean[n + 1];
        learnt = new boolean[k + 1];
        went[t] = learnt[cul[t]] = true;
        dfs(t, 0);
        System.out.println(ans > INF / 2 ? -1 : ans);
    }
}

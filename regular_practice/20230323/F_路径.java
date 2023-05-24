import java.util.*;
import java.io.*;

public class F_路径 {
    static final int M = 100000, INF = 0x3f3f3f3f;
    static int n = 2021;
    static int[] h = new int[n + 1], e = new int[M], w = new int[M], ne = new int[M];
    static int idx;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int spfa(int src, int dest) {
        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);
        dists[src] = 0;
        boolean[] has = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
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
        return dists[dest];
    }

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        Arrays.fill(h, -1);
        for (int u = 1; u <= n; ++u) {
            for (int v = 1; v < u; ++v) {
                if (u - v <= 21) {
                    int lcmuv = lcm(u, v);
                    add(u, v, lcmuv);
                    add(v, u, lcmuv);
                }
            }
        }
        System.out.println(spfa(1, n));
    }
}

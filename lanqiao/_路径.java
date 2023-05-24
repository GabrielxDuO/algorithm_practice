import java.util.*;
import java.io.*;

public class _路径 {
    static final int INF = 0x3f3f3f3f;
    static int n = 2021, m = n * n;
    static int[] h = new int[n + 1];
    static { Arrays.fill(h, -1); }
    static int[] e = new int[m];
    static int[] w = new int[m];
    static int[] ne = new int[m];
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
        boolean[] inque = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(src);
        inque[src] = true;
        while (!que.isEmpty()) {
            int u = que.poll();
            inque[u] = false;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (dists[u] + w[i] < dists[v]) {
                    dists[v] = dists[u] + w[i];
                    if (!inque[v]) {
                        que.offer(v);
                        inque[v] = true;
                    }
                }
            }
        }
        return dists[dest];
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (j - i <= 21) {
                    int m = lcm(i, j);
                    add(i, j, m); add(j, i, m);
                }
            }
        }
        System.out.println(spfa(1, n));
    }
}

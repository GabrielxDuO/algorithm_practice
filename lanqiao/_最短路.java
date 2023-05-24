import java.util.*;
import java.io.*;

public class _最短路 {
    static final int INF = 0x3f3f3f3f;
    static int N = 100, n = 's' - 'a' + 1;
    static int[] h = new int[n + 1], e = new int[N], w = new int[N], ne = new int[N];
    static int idx;

    static void undir(int a, int b, int c) {
        a -= 'a' - 1; b -= 'a' - 1;
        add(a, b, c);
        add(b, a, c);
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void init() {
        Arrays.fill(h, -1);
        // blue
        undir('a', 'c', 1);
        undir('a', 'd', 1);
        undir('a', 'e', 1);
        undir('d', 'e', 1);
        undir('d', 'h', 1);
        undir('e', 'h', 1);
        undir('h', 'i', 1);
        undir('b', 'g', 1);
        undir('g', 'f', 1);
        undir('f', 'j', 1);
        undir('k', 'n', 1);
        undir('n', 'p', 1);
        undir('p', 'o', 1);
        undir('o', 'q', 1);
        undir('q', 'm', 1);
        undir('m', 'l', 1);
        undir('l', 'r', 1);
        undir('r', 's', 1);
        undir('s', 'm', 1);
        // orange
        undir('a', 'b', 2);
        undir('b', 'j', 2);
        undir('j', 's', 2);
        undir('d', 'i', 2);
        undir('d', 'g', 2);
        undir('g', 'k', 2);
        undir('k', 'p', 2);
        undir('n', 'm', 2);
        undir('h', 'l', 2);
        // green
        undir('c', 'f', 3);
        undir('c', 'g', 3);
        undir('c', 'd', 3);
        undir('g', 'i', 3);
        undir('e', 'i', 3);
        undir('i', 'm', 3);
        undir('k', 'l', 3);
        undir('o', 'r', 3);
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
        init();
        System.out.println(spfa(1, n));
    }
}

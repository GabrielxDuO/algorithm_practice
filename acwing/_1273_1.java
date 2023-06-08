import java.util.*;
import java.io.*;

public class _1273 {
    static int n, m;
    static int[] a;
    static class Node {
        int l, r, mx;

        Node(int l, int r, int mx) {
            this.l = l;
            this.r = r;
            this.mx = mx;
        }
    }
    static Node[] tr;

    static void pushup(int u) {
        tr[u].mx = Math.max(tr[u << 1].mx, tr[u << 1 | 1].mx);
    }

    static void build(int u, int l, int r) {
        if (l == r) tr[u] = new Node(l, r, a[r]);
        else {
            tr[u] = new Node(l, r, 0);
            int m = l + r >> 1;
            build(u << 1, l, m);
            build(u << 1 | 1, m + 1, r);
            pushup(u);
        }
    }

    static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].mx;
        int m = tr[u].l + tr[u].r >> 1;
        int mx = Integer.MIN_VALUE;
        if (l <= m) mx = query(u << 1, l, r);
        if (r >= m + 1) mx = Math.max(mx, query(u << 1 | 1, l, r));
        return mx;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n + 1];
        tr = new Node[n * 4];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        build(1, 1, n);
        in.nextToken(); m = (int) in.nval;
        while (m-- > 0) {
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            System.out.println(query(1, l, r));
        }
    }
}

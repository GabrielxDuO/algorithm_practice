import java.util.*;
import java.io.*;

public class _1275 {
    static int m, p, a, n;
    static class Node {
        int l, r, mx;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    static Node[] tr;

    static void pushup(int u) {
        tr[u].mx = Math.max(tr[u << 1].mx, tr[u << 1 | 1].mx);
    }

    static void build(int u, int l, int r) {
        tr[u] = new Node(l, r);
        if (l == r) return;
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
    }

    static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].mx;
        int m = tr[u].l + tr[u].r >> 1;
        int res = 0;
        if (l <= m) res = query(u << 1, l, r);
        if (r >= m + 1) res = Math.max(res, query(u << 1 | 1, l, r));
        return res;
    }

    static void modify(int u, int i, int x) {
        if (tr[u].l == tr[u].r) tr[u].mx = x;
        else {
            int m = tr[u].l + tr[u].r >> 1;
            if (i <= m) modify(u << 1, i, x);
            else modify(u << 1 | 1, i, x);
            pushup(u);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); p = (int) in.nval;
        tr = new Node[m * 4];
        build(1, 1, m);
        while (m-- > 0) {
            in.nextToken(); char op = in.sval.charAt(0);
            in.nextToken(); int x = (int) in.nval;
            if (op == 'Q') {
                a = query(1, n - x + 1, n);
                System.out.println(a);
            } else modify(1, ++n, (int) ((1L * x + a) % p));
        }
    }
}

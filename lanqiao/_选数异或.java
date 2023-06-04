import java.util.*;
import java.io.*;

public class _选数异或 {
    static final int N = (1 << 20) + 10;
    static int n, m, x;
    // lefts[i]表示在a[i]左边最近的一个能使a[i]^a[j]==x的j
    static int[] lefts, poses = new int[N];
    static class Node {
        int l, r, mx;

        Node(int l, int r, int mx) {
            this.l = l;
            this.r = r;
            this.mx = mx;
        }
    }
    static Node[] tr;

    static void pushUp(int u) {
        tr[u].mx = Math.max(tr[u << 1].mx, tr[u << 1 | 1].mx);
    }

    static void build(int u, int l, int r) {
        if (l == r) tr[u] = new Node(l, r, lefts[r]);
        else {
            tr[u] = new Node(l, r, 0);
            int m = l + r >> 1;
            build(u << 1, l, m);
            build(u << 1 | 1, m + 1, r);
            pushUp(u);
        }
    }

    static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].mx;
        int m = tr[u].l + tr[u].r >> 1;
        int res = 0;
        if (l <= m) res = query(u << 1, l, r);
        if (r >= m + 1) res = Math.max(res, query(u << 1 | 1, l, r));
        return res;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); x = (int) in.nval;
        lefts = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); int num = (int) in.nval;
            lefts[i] = poses[num ^ x];
            poses[num] = i;
        }
        tr = new Node[n * 4];
        build(1, 1, n);
        while (m-- > 0) {
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            System.out.println(query(1, l, r) >= l ? "yes" : "no");
        }
    }
}

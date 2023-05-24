import java.util.*;
import java.io.*;

public class A_小球与盒子 {
    static int n, m;
    static long[] tr;

    static int lowbit(int x) {
        return x & -x;
    }

    static void add(int i, int x) {
        for (; i <= n; i += lowbit(i)) tr[i] += x;
    }

    static long query(int i) {
        long sum = 0;
        for (; i > 0; i -= lowbit(i)) sum += tr[i];
        return sum;
    }

    // static class Node {
    //     int l, r;
    //     long sum;

    //     public Node(int l, int r, long sum) {
    //         this.l = l;
    //         this.r = r;
    //         this.sum = sum;
    //     }
    // }
    // static Node[] tr;

    // static void pushup(int u) {
    //     tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
    // }

    // static void build(int u, int l, int r) {
    //     if (l == r) tr[u] = new Node(l, r, 0L);
    //     else {
    //         tr[u] = new Node(l, r, 0L);
    //         int m = l + r >> 1;
    //         build(u << 1, l, m);
    //         build(u << 1 | 1, m + 1, r);
    //     }
    // }

    // static long query(int u, int l, int r) {
    //     if (tr[u].l >= l && tr[u].r <= r) return tr[u].sum;
    //     int m = tr[u].l + tr[u].r >> 1;
    //     long sum = 0;
    //     if (l <= m) sum += query(u << 1, l, r);
    //     if (r >= m + 1) sum += query(u << 1 | 1, l, r);
    //     return sum;
    // }

    // static void modify(int u, int i, int x) {
    //     if (tr[u].l == tr[u].r) tr[u].sum += x;
    //     else {
    //         int m = tr[u].l + tr[u].r >> 1;
    //         if (i <= m) modify(u << 1, i, x);
    //         else modify(u << 1 | 1, i, x);
    //         pushup(u);
    //     }
    // }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        tr = new long[n + 1];
        // tr = new Node[4 * n + 10];
        // build(1, 1, n);
        while (m-- > 0) {
            in.nextToken();
            int op = (int) in.nval;
            in.nextToken();
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            if (op == 1) add(x, y);
            else System.out.println(query(y) - query(x - 1));
            // if (op == 1) modify(1, x, y);
            // else System.out.println(query(1, x, y));
        }
    }
}

import java.util.*;
import java.io.*;

public class R_晚会节目单 {
    static int n, m;
    static int[] a;
    static class Node {
        int l, r, maxId;

        public Node(int l, int r, int maxId) {
            this.l = l;
            this.r = r;
            this.maxId = maxId;
        }
    }
    static Node[] tr;

    static void pushup(int u) {
        int lId = tr[u << 1].maxId, rId = tr[u << 1 | 1].maxId;
        tr[u].maxId = a[lId] >= a[rId] ? lId : rId;
    }

    static void build(int u, int l, int r) {
        tr[u] = new Node(l, r, 0);
        if (l == r) tr[u] = new Node(l, r, r);
        else {
            int m = l + r >> 1;
            build(u << 1, l, m);
            build(u << 1 | 1, m + 1, r);
            pushup(u);
        }
    }

    static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].maxId;
        } else {
            int m = tr[u].l + tr[u].r >> 1;
            int lId = -1, rId = -1;
            if (l <= m) lId = query(u << 1, l, r);
            if (r >= m + 1) rId = query(u << 1 | 1, l, r);
            if (lId == -1) return rId;
            else if (rId == -1) return lId;
            else return a[lId] >= a[rId] ? lId : rId;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        a = new int[n + 1];
        tr = new Node[n * 4];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        build(1, 1, n);
        int prevId = 0;
        while (m > 0) {
            int maxId = query(1, prevId + 1, n - m + 1);
            System.out.print(a[maxId] + " ");
            prevId = maxId;
            --m;
        }
    }
}

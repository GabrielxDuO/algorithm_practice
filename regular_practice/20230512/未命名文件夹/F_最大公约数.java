import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] a;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class Node {
        int l, r, d;
        
        public Node(int l, int r, int d) {
            this.l = l;
            this.r = r;
            this.d = d;
        }
    }
    static Node[] tr;
    
    static void pushup(int u) {
        tr[u].d = gcd(tr[u << 1].d, tr[u << 1 | 1].d);
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
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].d;
        else {
            int m = tr[u].l + tr[u].r >> 1;
            int d = 0;
            if (l <= m) d = gcd(d, query(u << 1, l, r));
            if (r >= m + 1) d = gcd(d, query(u << 1 | 1, l, r));
            return d;
        }
    }

    static boolean check(int m) {
        for (int i = 1; i + m <= n; ++i) {
            if (query(1, i, i + m) == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n + 1];
        int oneCnt = 0;
        tr = new Node[n * 4];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
            if (a[i] == 1) ++oneCnt;
        }
        if (oneCnt > 0) {
            System.out.println(n - oneCnt);
            return;
        }
        build(1, 1, n);
        if (query(1, 1, n) > 1) {
            System.out.println(-1);
            return;
        }
        int l = 1, r = n - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        System.out.println(l + n - 1);
    }
}

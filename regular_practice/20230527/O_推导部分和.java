import java.util.*;
import java.io.*;

public class O_推导部分和 {
    static final int N = (int) 1e5 + 10;
    static int n, m, q;
    static int[] roots = new int[N];
    static long[] s = new long[N];
    static {
        for (int i = 0; i < N; ++i) roots[i] = i;
    }

    static int find(int x) {
        if (roots[x] != x) {
            int rx = find(roots[x]);
            s[x] += s[roots[x]];
            roots[x] = rx;
        }
        return roots[x];
    }

    static void union(int p, int q, long k) {
        int rp = find(p), rq = find(q);
        roots[rq] = rp;
        s[rq] = k - s[q] + s[p];
    }


    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); q = (int) in.nval;
        while (m-- > 0) {
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            in.nextToken(); long s = (long) in.nval;
            union(l - 1, r, s);
        }
        while (q-- > 0) {
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            int rl = find(l - 1), rr = find(r);
            if (rl != rr) System.out.println("UNKNOWN");
            else System.out.println(s[r] - s[l - 1]);
        }
    }
}

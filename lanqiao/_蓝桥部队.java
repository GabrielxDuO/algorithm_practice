import java.util.*;
import java.io.*;

public class _蓝桥部队 {
    static int[] roots, sizes;

    static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }

    static void union(int p, int q) {
        int rp = find(p), rq = find(q);
        if (rp != rq) {
            roots[rp] = rq;
            sizes[rq] += sizes[rp];
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        roots = new int[n + 1];
        sizes = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            roots[i] = i;
            sizes[i] = 1;
        }
        while (m-- > 0) {
            in.nextToken();
            int op = (int) in.nval;
            in.nextToken();
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            if (op == 1) union(x, y);
            else System.out.println(find(x) == find(y) ? sizes[find(x)] - 2 : -1);
        }
    }
}

import java.util.*;
import java.io.*;

public class I_合根植物 {
    static int n, m, k;
    static int[] roots;
    static int cnt;

    static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }

    static void union(int p, int q) {
        p = find(p); q = find(q);
        if (p == q) return;
        roots[p] = q;
        --cnt;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); k = (int) in.nval;
        cnt = n * m;
        roots = new int[cnt + 1];
        for (int i = 1; i <= cnt; ++i) roots[i] = i;
        while (k-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            union(a, b);
        }
        System.out.println(cnt);
    }
}

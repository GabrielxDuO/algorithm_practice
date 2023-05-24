import java.util.*;
import java.io.*;

public class _团伙 {
    static int[] roots;
    static int cnt;

    static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }

    static void union(int p, int q) {
        roots[find(p)] = find(q);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        roots = new int[n * 2 + 1];
        for (int i = 1; i <= 2 * n; ++i) roots[i] = i;
        while (m-- > 0) {
            in.nextToken(); int p = (int) in.nval;
            in.nextToken(); int x = (int) in.nval;
            in.nextToken(); int y = (int) in.nval;
            if (p == 0) union(x, y);
            else {
                union(x + n, y);
                union(y + n, x);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (roots[i] == i) ++ans;
        }
        System.out.println(ans);
    }
}

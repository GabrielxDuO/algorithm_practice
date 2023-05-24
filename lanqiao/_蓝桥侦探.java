import java.util.*;
import java.io.*;

public class _蓝桥侦探 {
    static int[] roots;

    static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }

    static void union(int p, int q) {
        roots[find(p)] = find(q);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        roots = new int[n * 2 + 10];
        for (int i = 1; i < n * 2 + 10; ++i) roots[i] = i;
        while (m-- > 0) {
            in.nextToken();
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            if (find(x) == find(y)) {
                System.out.println(x);
                break;
            }
            union(x + n, y);
            union(x, y + n);
        }
    }
}

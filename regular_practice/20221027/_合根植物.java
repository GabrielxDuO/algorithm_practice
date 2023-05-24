import java.util.*;
import java.io.*;

public class _合根植物 {
    static int[] roots;
    static int groups;

    static void union(int p, int q) {
        int rp = find(p), rq = find(q);
        if (rp != rq) {
            roots[rp] = rq;
            --groups;
        }
    }

    static int find(int x) {
        return x == roots[x] ? x : (roots[x] = find(roots[x]));
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        int N = n * m;
        roots = new int[N];
        groups = N;
        for (int i = 0; i < N; ++i) roots[i] = i;
        while (k-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            union(a - 1, b - 1);
        }
        System.out.println(groups);
    }
}

import java.io.*;
import java.util.*;

public class _010 {
    static final int N = 110;
    static int n, m, k;
    static int[] roots = new int[N];
    static boolean[][] enemy = new boolean[N][N];

    static int find(int x) {
        return x == roots[x] ? x : (roots[x] = find(roots[x]));
    }

    static void join(int p, int q) {
        roots[find(p)] = find(q);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        for (int i = 0; i <= n; ++i) roots[i] = i;
        while (m-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            in.nextToken();
            int rela = (int) in.nval;
            if (rela != -1) join(a, b);
            else enemy[a][b] = enemy[b][a] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (k-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            int res = 0;
            if (a == b) {
                System.out.println("OK");
                continue;
            }
            if (find(a) == find(b)) res |= 1;
            if (enemy[a][b]) res |= 2;
            if (res == 0) ans.append("OK\n");
            else if (res == 1) ans.append("No problem\n");
            else if (res == 3) ans.append("OK but...\n");
            else ans.append("No way\n");
        }
        System.out.print(ans);
    }
}

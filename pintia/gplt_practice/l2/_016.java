import java.io.*;
import java.util.*;

public class _016 {
    static final int N = (int) 1e5 + 10;
    static int n, k;
    static boolean[] sex = new boolean[N];
    static int[] fa = new int[N];
    static int[] mo = new int[N];
    static Set<Integer> vis;
    static int[] que = new int[100];
    static int hh, tt;

    static boolean check(int a, int b) {
        hh = 0; tt = -1;
        que[++tt] = a;
        vis.clear();
        for (int i = 0; i < 5; ++i) {
            int sz = tt - hh + 1;
            while (sz-- > 0) {
                int u = que[hh++];
                vis.add(u);
                if (fa[u] != -1) que[++tt] = fa[u];
                if (mo[u] != -1) que[++tt] = mo[u];
            }
        }
        hh = 0; tt = -1;
        que[++tt] = b;
        for (int i = 0; i < 5; ++i) {
            int sz = tt - hh + 1;
            while (sz-- > 0) {
                int u = que[hh++];
                if (vis.contains(u)) return true;
                if (fa[u] != -1) que[++tt] = fa[u];
                if (mo[u] != -1) que[++tt] = mo[u];
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        vis = new HashSet<>();
        Arrays.fill(fa, -1);
        Arrays.fill(mo, -1);
        for (int i = 1; i <= n; i++) {
            in.nextToken(); int u = (int) in.nval;
            in.nextToken(); char[] s = in.sval.toCharArray();
            in.nextToken(); int f = (int) in.nval;
            in.nextToken(); int m = (int) in.nval;
            fa[u] = f;
            mo[u] = m;
            if (f != -1) sex[f] = true;
            if (m != -1) sex[m] = false;
            sex[u] = (s[0] == 'M');
        }
        in.nextToken(); k = (int) in.nval;
        while (k-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            if (sex[a] == sex[b]) System.out.println("Never Mind");
            else System.out.println(check(a, b) ? "No" : "Yes");
        }
    }
}

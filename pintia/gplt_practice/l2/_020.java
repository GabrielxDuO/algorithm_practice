import java.io.*;
import java.util.*;

public class _020 {
    static final int N = (int) 1e5 + 10;
    static int n;
    static double z, r;
    static int[] scale = new int[N];
    static int[] h = new int[N], e = new int[N], ne = new int[N];
    static int idx = 0;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static double dfs(int u, double x) {
        if (scale[u] != 0) return x * r * scale[u];
        double w = x * r;
        double sum = 0.0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            sum += dfs(v, w);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); z = in.nval;
        in.nextToken(); r = in.nval;
        r = (100.0 - r) / 100.0;
        Arrays.fill(h, -1);
        int k, v;
        for (int u = 0; u < n; ++u) {
            in.nextToken(); k = (int) in.nval;
            if (k == 0) {
                in.nextToken(); scale[u] = (int) in.nval;
                continue;
            }
            while (k-- > 0) {
                in.nextToken(); v = (int) in.nval;
                add(u, v);
            }
        }
        if (n == 1) {
            System.out.printf("%.0f\n", z * scale[0] - 0.5);
            return;
        }
        double sum = 0.0;
        for (int i = h[0]; i != -1; i = ne[i]) sum += dfs(e[i], z);
        System.out.printf("%.0f\n", sum - 0.5);
    }
}

import java.util.*;
import java.io.*;

public class _蓝桥公园 {
    static final long INF = 0x3f3f3f3f3f3f3f3fL;
    static int n, m, q;
    static long[][] dists;

    static void floyd() {
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        in.nextToken();
        q = (int) in.nval;
        dists = new long[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i != j) dists[i][j] = INF;
            }
        }
        while (m-- > 0) {
            in.nextToken();
            int u = (int) in.nval;
            in.nextToken();
            int v = (int) in.nval;
            in.nextToken();
            int w = (int) in.nval;
            dists[u][v] = dists[v][u] = Math.min(dists[u][v], w);
        }
        floyd();
        while (q-- > 0) {
            in.nextToken();
            int st = (int) in.nval;
            in.nextToken();
            int ed = (int) in.nval;
            System.out.println(dists[st][ed]);
        }
    }
}

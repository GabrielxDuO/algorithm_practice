import java.util.*;
import java.io.*;

public class _1273_2 {
    static int n, m;
    static int[] a;
    static int[][] f;
    static int[] log2;

    static void init() {
        int k = (int) (Math.log(n) / Math.log(2)) + 1;
        log2 = new int[n + 1];
        for (int i = 0; i < k; ++i) log2[1 << i] = i;
        for (int i = 1; i <= n; ++i) {
            if (log2[i] == 0) log2[i] = log2[i - 1];
        }
        f = new int[n + 1][k];
        for (int j = 0; j < k; ++j) {
            for (int i = 1; i + (1 << j) - 1 <= n; ++i) {
                if (j == 0) f[i][j] = a[i];
                else f[i][j] = Math.max(f[i][j - 1], f[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    static int query(int l, int r) {
        int len = r - l + 1;
        int k = log2[len];
        return Math.max(f[l][k], f[r - (1 << k) + 1][k]);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        init();
        in.nextToken(); m = (int) in.nval;
        while (m-- > 0) {
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            System.out.println(query(l, r));
        }
    }
}

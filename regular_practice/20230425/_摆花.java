import java.util.*;
import java.io.*;

public class _摆花 {
    static final int MOD = 1000007;
    static int n, m;
    static int[] a;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        a = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= a[i] && k <= j; ++k) {
                    f[i][j] = (f[i][j] + f[i - 1][j - k]) % MOD;
                }
            }
        }
        System.out.println(f[n][m]);
    }
}

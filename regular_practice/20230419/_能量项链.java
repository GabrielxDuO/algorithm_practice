import java.util.*;
import java.io.*;

public class _能量项链 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[] a = new int[2 * n + 2];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = a[n + i] = (int) in.nval;
        }
        int[][] f = new int[2 * n + 1][2 * n + 1];
        for (int len = 2; len <= n; ++len) {
            for (int i = 1; i + len - 1 <= 2 * n; ++i) {
                int j = i + len - 1;
                for (int k = i; k < j; ++k) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k + 1][j] + a[i] * a[k + 1] * a[j + 1]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) ans = Math.max(ans, f[i][i + n - 1]);
        System.out.println(ans);
    }
}

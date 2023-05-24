import java.util.*;
import java.io.*;

public class _耐摔指数 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = 3;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) f[i][1] = i;
        for (int i = 1; i <= m; ++i) f[1][m] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 2; j <= m; ++j) {
                int mn = Integer.MAX_VALUE;
                for (int k = 1; k <= i; ++k) {
                    mn = Math.min(mn, Math.max(f[k - 1][j - 1], f[i - k][j]) + 1);
                }
                f[i][j] = Math.min(mn, f[i][j - 1]);
            }
        }
        System.out.println(f[n][m]);
    }
}

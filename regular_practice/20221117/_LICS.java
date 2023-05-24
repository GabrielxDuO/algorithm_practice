import java.util.*;
import java.io.*;

public class _LICS {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[] a = new int[n + 1], b = new int[m + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        for (int i = 1; i <= m; ++i) {
            in.nextToken();
            b[i] = (int) in.nval;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (a[i] == b[j]) {
                    for (int k = 0; k < j; ++k) {
                        if (b[j] > b[k]) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + 1);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= m; ++i) ans = Math.max(ans, dp[n][i]);
        System.out.println(ans);
    }
}

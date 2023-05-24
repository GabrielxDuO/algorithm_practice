import java.util.*;
import java.io.*;

public class _最长公共子序列 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        for (int i = 0; i < m; ++i) {
            in.nextToken();
            b[i] = (int) in.nval;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[n][m]);
    }
}

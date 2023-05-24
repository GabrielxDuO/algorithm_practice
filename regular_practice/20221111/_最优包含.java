import java.util.*;
import java.io.*;

public class _最优包含 {
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();
        char[] t = in.readLine().toCharArray();
        int n = s.length, m = t.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) dp[i][0] = 0;
        for (int j = 1; j <= m; ++j) dp[0][j] = INF;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s[i - 1] == t[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
            }
        }
        System.out.println(dp[n][m]);
    }
}

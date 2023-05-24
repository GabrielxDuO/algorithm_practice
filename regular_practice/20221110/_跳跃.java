import java.util.*;
import java.io.*;

public class _跳跃 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] g = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                in.nextToken();
                g[i][j] = (int) in.nval;
            }
        }
        int[][] dp = new int[n][m];
        dp[0][0] = g[0][0];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0 && j == 0) continue;
                int max = Integer.MIN_VALUE;
                for (int x = 0; x <= 3; ++x) {
                    if (i - x < 0) continue;
                    for (int y = 0; y <= 3 - x; ++y) {
                        if (j - y < 0 || x == 0 && y == 0) continue;
                        max = Math.max(max, dp[i - x][j - y]);
                    }
                }
                dp[i][j] = g[i][j] + max;
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}

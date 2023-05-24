import java.util.*;
import java.io.*;

public class _数学中的学问 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        in.nextToken();
        int p = (int) in.nval;
        int[][] dp = new int[n + 1][n + 1];
        dp[3][1] = 2;
        for (int i = 4; i <= n; ++i) {
            for (int j = 1; j * 3 <= i && j <= k; ++j) {
                dp[i][j] = dp[i - 1][j] * (i - 1) % p;
                dp[i][j] = (dp[i][j] + dp[i - 3][j - 1] * (i - 1) * (i - 2)) % p;
            }
        }
        System.out.println(dp[n][k]);
    }
}

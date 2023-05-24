import java.io.*;
import java.util.*;

public class _A {
    static final int INF = 0x3f3f3f3f;
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        char[] seeds = in.sval.toCharArray();
        int n = seeds.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp) Arrays.fill(arr, INF); 
        for (int l = n - 1; l >= 0; --l) {
            for (int r = l; r < n; ++r) {
                if (l == r) dp[l][r] = 0;
                else if (seeds[l] == seeds[r]) {
                    if (Math.abs(r - l) == 1) dp[l][r] = 0;
                    else dp[l][r] = Math.min(dp[l][r], dp[l + 1][r - 1]);
                } else dp[l][r] = Math.min(dp[l][r], Math.min(dp[l + 1][r] + 1, dp[l][r - 1] + 1));
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
import java.io.*;
import java.util.*;

public class _A_dp {
    static final int MOD = (int) 1e9 + 7;
    static final int[] opp = {-1, 4, 5, 6, 1, 2, 3};
    static boolean[][] conflict = new boolean[7][7];
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        while (m-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            conflict[a][b] = true;
            conflict[b][a] = true;
        }
        long[][] dp = new long[2][7];
        Arrays.fill(dp[0], 1);
        int prev = 1, curr = 0;
        for (int level = 2; level <= n; ++level) {
            int tmp = prev;
            prev = curr;
            curr = tmp;
            for (int upperTop = 1; upperTop <= 6; ++upperTop) {
                long poss = 0L;
                int upperBottom = opp[upperTop];
                for (int lowerTop = 1; lowerTop <= 6; ++lowerTop) {
                    if (conflict[lowerTop][upperBottom]) continue;
                    poss = (poss + dp[prev][lowerTop]) % MOD;
                }
                dp[curr][upperTop] = poss;
            }
        }
        long sum = 0L;
        for (int i = 1; i <= 6; ++i) sum = (sum + dp[curr][i]) % MOD;
        long ans = 1L, base = 4L;
        while (n != 0) {
            if ((n & 1) != 0) ans = (ans * base) % MOD;
            base = (base * base) % MOD;
            n >>= 1;
        }
        System.out.println((sum * ans) % MOD);
    }
}

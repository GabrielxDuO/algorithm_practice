import java.util.*;
import java.io.*;

public class _垒骰子 {
    static final int MOD = (int) 1e9 + 7;
    static final int[] OPP = {-1, 4, 5, 6, 1, 2, 3};
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
        long[] prev = new long[7], curr = new long[7];
        Arrays.fill(prev, 1);
        for (int level = 2; level <= n; ++level) {
            for (int upperTop = 1; upperTop <= 6; ++upperTop) {
                long poss = 0L;
                int upperBottom = OPP[upperTop];
                for (int lowerTop = 1; lowerTop <= 6; ++lowerTop) {
                    if (conflict[upperTop][lowerTop]) continue;
                    poss = (poss + prev[lowerTop]) % MOD;
                }
                curr[upperTop] = poss;
            }
            prev = Arrays.copyOf(curr, 7);
        }
        long sum = 0L;
        for (int i = 1; i <= 6; ++i) sum = (sum + curr[i]) % MOD;
        long ans = 1L, base = 4L;
        while (n != 0) {
            if ((n & 1) != 0) ans = ans * base % MOD;
            base = base * base % MOD;
            n >>= 1;
        }
        System.out.println(ans * sum % MOD);
    }
}

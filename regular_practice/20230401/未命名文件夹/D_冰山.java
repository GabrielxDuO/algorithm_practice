import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        in.nextToken(); int k = (int) in.nval;
        long[] pcs = new long[k + 1];
        while (n-- > 0) {
            in.nextToken(); int v = (int) in.nval;
            ++pcs[v];
        }
        while (m-- > 0) {
            long[] ccs = new long[k + 1];
            in.nextToken(); int x = (int) in.nval;
            in.nextToken(); int y = (int) in.nval;
            long nc = 0L;
            for (int v = 1; v <= k; ++v) {
                if (v + x <= 0) continue;
                else if (v + x <= k) {
                    ccs[v + x] = pcs[v];
                } else if (v + x > k) {
                    ccs[k] = (ccs[k] + pcs[v]) % MOD;
                    nc = (nc + (v + x - k) * pcs[v] % MOD) % MOD;
                }
            }
            ccs[1] += nc;
            ++ccs[y];
            long tv = 0L;
            for (int v = 1; v <= k; ++v) {
                tv = (tv + v * (ccs[v] % MOD) % MOD) % MOD;
            }
            System.out.println(tv);
            pcs = ccs;
        }
    }
}

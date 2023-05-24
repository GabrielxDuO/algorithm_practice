import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        in.nextToken(); int k = (int) in.nval;
        long[] a = new long[k + 1], b = new long[k + 1];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int v = (int) in.nval;
            ++a[v];
        }
        while (m-- > 0) {
            in.nextToken(); int x = (int) in.nval;
            in.nextToken(); int y = (int) in.nval;
            Arrays.fill(b, 0L);
            for (int i = 1; i <= k; ++i) {
                if (i + x <= 0) continue;
                else if (i + x > k) {
                    b[k] = (b[k] + a[i]) % MOD;
                    b[1] = (b[1] + a[i] * (i + x - k) % MOD) % MOD;
                } else b[i + x] = (b[i + x] + a[i]) % MOD;
            }
            ++b[y];
            a = b.clone();
            long ans = 0L;
            for (int i = 1; i <= k; ++i) {
                ans = (ans + (1L * i * a[i]) % MOD) % MOD;
            }
            System.out.println(ans);
        }
    }
}

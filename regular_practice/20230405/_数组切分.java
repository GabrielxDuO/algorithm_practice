import java.util.*;
import java.io.*;

public class _数组切分 {
    static final int MOD = (int) 1e9 + 7;
    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            for (int j = i; j >= 1; --j) {
                mn = Math.min(mn, a[j]);
                mx = Math.max(mx, a[j]);
                if (mx - mn == i - j) f[i] = (f[i] + f[j - 1]) % MOD;
            }
        }
        System.out.println(f[n]);
    }
}

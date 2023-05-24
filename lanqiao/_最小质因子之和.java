import java.util.*;
import java.io.*;

public class _最小质因子之和 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int t = (int) in.nval;
        int[] a = new int[t];
        int mx = 0;
        for (int i = 0; i < t; ++i) {
            in.nextToken();
            int x = (int) in.nval;
            a[i] = x;
            mx = Math.max(mx, x);
        }
        int cnt = 0;
        int[] primes = new int[mx + 1];
        boolean[] isNotPrime = new boolean[mx + 1];
        long[] b = new long[mx + 1], s = new long[mx + 1];
        for (int i = 2; i <= mx; ++i) {
            if (!isNotPrime[i]) {
                primes[cnt++] = i;
                b[i] = i;
                for (int j = i + i; j <= mx; j += i) {
                    if (!isNotPrime[j]) {
                        isNotPrime[j] = true;
                        if (b[j] == 0) b[j] = i;
                    }
                }
            }
        }
        for (int i = 1; i <= mx; ++i) s[i] = s[i - 1] + b[i];
        for (int i = 0; i < t; ++i) {
            System.out.println(s[a[i]]);
        }
    }
}

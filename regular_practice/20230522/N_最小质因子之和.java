import java.util.*;
import java.io.*;

public class N_最小质因子之和 {
    static final int N = (int) 3e6;
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] np = new boolean[N + 1];
    static long[] s = new long[N + 1];

    static {
        for (int x = 2; x <= N; ++x) {
            if (!np[x]) primes[cnt++] = x;
            for (int i = 0; primes[i] < N / x; ++i) {
                np[x * primes[i]] = true;
                if (x % primes[i] == 0) break;
            }
        }
        for (int x = 2; x <= N; ++x) {
            int p = x;
            if (np[x]) {
                for (int i = 0; i < cnt; ++i) {
                    if (x % primes[i] == 0) {
                        p = primes[i];
                        break;
                    }
                }
            }
            s[x] = s[x - 1] + p;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); int n = (int) in.nval;
            System.out.println(s[n]);
        }
    }
}

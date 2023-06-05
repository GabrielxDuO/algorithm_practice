import java.util.*;
import java.io.*;

public class _201 {
    static final int N = 1000;
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] np = new boolean[N + 1];
    static int[] phi = new int[N + 1];
    static int[] s = new int[N + 1];

    static {
        phi[1] = 1;
        for (int x = 2; x <= N; ++x) {
            if (!np[x]) {
                primes[cnt++] = x;
                phi[x] = x - 1;
            }
            for (int i = 0; primes[i] <= N / x; ++i) {
                np[primes[i] * x] = true;
                if (x % primes[i] == 0) {
                    phi[x * primes[i]] = phi[x] * primes[i];
                    break;
                }
                phi[x * primes[i]] = phi[x] * (primes[i] - 1);
            }
        }
        for (int i = 1; i <= N; ++i) s[i] = s[i - 1] + phi[i];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); int t = (int) in.nval;
        for (int i = 1; i <= t; ++i) {
            in.nextToken(); int n = (int) in.nval;
            out.println(i + " " + n + " " + (s[n] * 2 + 1));
        }
        out.flush();
        out.close();
    }
}

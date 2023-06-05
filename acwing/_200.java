import java.util.*;
import java.io.*;

public class _200 {
    static final int N = (int) Math.sqrt(2e9) + 1;
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] np = new boolean[N + 1];
    static int n;
    static int a0, a1, b0, b1;
    static int[][] pfs = new int[20][2];
    static int pfcnt;
    static int[] divisors = new int[1700];
    static int dcnt;

    static {
        for (int x = 2; x <= N; ++x) {
            if (!np[x]) primes[cnt++] = x;
            for (int i = 0; primes[i] <= N / x; ++i) {
                np[primes[i] * x] = true;
                if (x % primes[i] == 0) break;
            }
        }
    }

    static void pf(int n) {
        pfcnt = 0;
        for (int i = 0; i < cnt && primes[i] <= n / primes[i]; ++i) {
            int p = primes[i];
            if (n % p == 0) {
                int s = 0;
                while (n % p == 0) {
                    n /= p;
                    ++s;
                }
                pfs[pfcnt++] = new int[]{p, s};
            }
        }
        if (n > 1) pfs[pfcnt++] = new int[]{n, 1};
    }

    static void dfs(int u, int p) {
        if (u == pfcnt) {
            divisors[dcnt++] = p;
            return;
        }
        for (int i = 0; i <= pfs[u][1]; ++i) {
            dfs(u + 1, (int) (p * Math.pow(pfs[u][0], i)));
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (int) (1L * a * b / gcd(a, b));
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        while (n-- > 0) {
            in.nextToken(); a0 = (int) in.nval;
            in.nextToken(); a1 = (int) in.nval;
            in.nextToken(); b0 = (int) in.nval;
            in.nextToken(); b1 = (int) in.nval;
            pf(b1);
            dcnt = 0;
            dfs(0, 1);
            int xcnt = 0;
            for (int i = 0; i < dcnt; ++i) {
                int x = divisors[i];
                if (gcd(x, a0) == a1 && lcm(x, b0) == b1) ++xcnt;
            }
            System.out.println(xcnt);
        }
        
    }
}

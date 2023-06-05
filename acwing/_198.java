import java.util.*;
import java.io.*;

// https://www.acwing.com/solution/content/47849/
public class _198 {
    static final int N = 100;
    static int[] primes = new int[N];
    static int cnt;
    static boolean[] np = new boolean[N + 1];
    static int n, maxExpo;
    static long ans;
    static int maxCnt;

    static void sieve(int maxProd) {
        long prod = 1L;
        for (int x = 2; x <= N; ++x) {
            if (!np[x]) {
                primes[cnt++] = x;
                if ((prod *= x) > maxProd) break;
            }
            for (int i = 0; primes[i] <= N / x; ++i) {
                np[primes[i] * x] = true;
                if (x % primes[i] == 0) break;
            }
        }
    }

    static void dfs(int u, long curr, int prev, int cnt) {
        if (estCnt < maxCnt) return;
        if (cnt > maxCnt || cnt == maxCnt && curr < ans) {
            ans = curr;
            maxCnt = cnt;
        }
        if (u >= cnt) return;
        for (int i = 1; i <= prev; ++i) {
            if (curr * Math.pow(primes[u], i) > n) continue;
            dfs(u + 1, (long) (curr * Math.pow(primes[u], i)), i, cnt * (i + 1));
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        sieve(n);
        maxExpo = (int) (Math.log(n) / Math.log(2));
        ans = n;
        dfs(0, 1L, maxExpo, 1);
        System.out.println(ans);
    }
}

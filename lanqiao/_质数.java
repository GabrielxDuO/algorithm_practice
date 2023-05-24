import java.util.*;
import java.io.*;

public class _质数 {
    static int n;
    static int[] primes;
    static boolean[] np;
    static int cnt;

    static void sieve() {
        for (int x = 2; x < n; ++x) {
            if (!np[x]) primes[cnt++] = x;
            for (int i = 0; primes[i] <= (n - 1) / x; ++i) {
                np[primes[i] * x] = true;
                if (x % primes[i] == 0) break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        primes = new int[n];
        np = new boolean[n];
        sieve();
        for (int i = 0; i < cnt; ++i) {
            System.out.print(primes[i] + " ");
        }
        System.out.println("\n" + cnt);
    }
}

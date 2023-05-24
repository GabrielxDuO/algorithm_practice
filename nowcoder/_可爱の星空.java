import java.util.*;
import java.io.*;

public class _可爱の星空 {
    static Map<Long, Long> memo = new HashMap<>();
    static {
        memo.put(1L, 0L);
        memo.put(2L, 0L);
    }

    static long f(long n) {
        if (!memo.containsKey(n)) {
            long res;
            if ((n & 1) == 1) res = f(n / 2) + f(n / 2 + 1) + 1;
            else res = 2 * f(n / 2);
            memo.put(n, res);
        }
        return memo.get(n);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); long n = (long) in.nval;
            System.out.println(f(n));
        }
    }
}

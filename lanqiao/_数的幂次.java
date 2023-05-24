import java.util.*;
import java.io.*;

public class _数的幂次 {
    static long kasumi(long base, long exp, long mod) {
        long res = 1L;
        while (exp > 0) {
            if ((exp & 1) != 0) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken();
            long n = (long) in.nval;
            in.nextToken();
            long m = (long) in.nval;
            in.nextToken();
            long p = (long) in.nval;
            System.out.println(kasumi(n, m, p));
        }
    }
}

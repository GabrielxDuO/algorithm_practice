import java.util.*;
import java.io.*;

public class Main {
    static final long N = (long) 1e12;
    static final int M = (int) Math.sqrt(2 * N);
    static long[] s = new long[M + 1];

    static {
        for (int i = 1; i <= M; ++i) {
            s[i] = s[i - 1] + 1L * i * (i + 1) / 2;
        }
    }

    static long get(long x) {
        long l = 0, r = (int) Math.sqrt(2 * x);
        while (l < r) {
            long m = l + (r - l + 1 >> 1);
            if (m * (m + 1) / 2 < x) l = m;
            else r = m - 1;
        }
        long sum = s[(int) l];
        x -= l * (l + 1) / 2;
        sum += x * (x + 1) / 2;
        return sum;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); long l = (long) in.nval;
            in.nextToken(); long r = (long) in.nval;
            System.out.println(get(r) - get(l - 1));
        }
    }
}

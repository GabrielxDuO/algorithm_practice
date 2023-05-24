import java.util.*;
import java.io.*;

public class _123 {
    static final int N = (int) Math.sqrt(2 * 1e12 + 0.5) + 1;
    static long[] a = new long[N + 1], s = new long[N + 1];
    static {
        for (int i = 1; i <= N; ++i) {
            a[i] = a[i - 1] + i;
            s[i] = s[i - 1] + a[i];
        }
    }

    static long find(long x) {
        int l = 0, r = N;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (a[m] <= x) l = m;
            else r = m - 1;
        }
        return s[l] + a[(int) (x - a[l])];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken();
            long l = (long) in.nval;
            in.nextToken();
            long r = (long) in.nval;
            System.out.println(find(r) - find(l - 1));
        }
    }
}

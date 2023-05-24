import java.util.*;
import java.io.*;

public class S_123 {
    static int N = (int) 1.5e6;
    static long[] a = new long[N], s = new long[N];

    static {
        for (int i = 1; i < N; ++i) {
            a[i] = 1L * i * (i + 1) / 2;
            s[i] = s[i - 1] + a[i];
        }
    }

    static int search(long x) {
        int l = 0, r = N - 1;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (1L * m * (m + 1) / 2 <= x) l = m;
            else r = m - 1;
        }
        return r;
    }

    static long get(long x) {
        int low = search(x);
        long pos = a[low];
        long rest = x - pos;
        return s[low] + a[(int) rest];
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

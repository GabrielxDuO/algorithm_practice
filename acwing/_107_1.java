import java.util.*;
import java.io.*;

public class _107_1 {
    static final int N = (int) 5e5 + 10;
    static int n;
    static int[] a = new int[N], b = new int[N];

    static long msort(int l, int r) {
        if (l == r) return 0;
        int m = l + r >> 1;
        long cnt = msort(l, m) + msort(m + 1, r);
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] > a[j]) {
                b[k++] = a[j++];
                cnt += m - i + 1;
            } else b[k++] = a[i++];
        }
        while (i <= m) b[k++] = a[i++];
        while (j <= r) b[k++] = a[j++];
        for (k = l; k <= r; ++k) a[k] = b[k];
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        while (in.nextToken() != in.TT_EOF && (n = (int) in.nval) != 0) {
            for (int i = 0; i < n; ++i) {
                in.nextToken(); a[i] = (int) in.nval;
            }
            System.out.println(msort(0, n - 1));
        }
    }
}

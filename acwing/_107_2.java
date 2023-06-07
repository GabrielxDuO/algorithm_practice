import java.util.*;
import java.io.*;

public class _107_2 {
    static final int N = (int) 5e5 + 10;
    static int n;
    static int[] a = new int[N], b;
    static int cnt;
    static int[] tr = new int[N];

    static int unique() {
        Arrays.sort(b, 0, n);
        int i = 0, j = 0;
        for (; j < n; ++j) {
            if (b[i] != b[j]) b[++i] = b[j];
        }
        return i + 1;
    }

    static int get(int x) {
        int l = 0, r = cnt - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (b[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int lowbit(int x) {
        return x & -x;
    }

    static void add(int i, int x) {
        for (; i <= n; i += lowbit(i)) tr[i] += x;
    }

    static int query(int i) {
        int sum = 0;
        for (; i > 0; i -= lowbit(i)) sum += tr[i];
        return sum;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        while (in.nextToken() != in.TT_EOF && (n = (int) in.nval) != 0) {
            for (int i = 0; i < n; ++i) {
                in.nextToken(); a[i] = (int) in.nval;
            }
            b = a.clone();
            cnt = unique();
            long ans = 0L;
            Arrays.fill(tr, 0);
            for (int i = n - 1; i >= 0; --i) {
                int x = get(a[i]) + 1;
                ans += query(x - 1);
                add(x, 1);
            }
            System.out.println(ans);
        }
    }
}

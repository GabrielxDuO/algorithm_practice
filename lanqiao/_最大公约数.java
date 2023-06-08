import java.util.*;
import java.io.*;

public class _最大公约数 {
    static int n;
    static int[] a;
    static int[][] f;
    static int[] log2;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void init() {
        int k = (int) (Math.log(n) / Math.log(2)) + 1;
        log2 = new int[n + 1];
        for (int i = 0; i < k; ++i) log2[1 << i] = i;
        for (int i = 1; i <= n; ++i) {
            if (log2[i] == 0) log2[i] = log2[i - 1];
        }
        f = new int[n + 1][k];
        for (int j = 0; j < k; ++j) {
            for (int i = 1; i + (1 << j) - 1 <= n; ++i) {
                if (j == 0) f[i][j] = a[i];
                else f[i][j] = gcd(f[i][j - 1], f[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    static int query(int l, int r) {
        int len = r - l + 1;
        int k = log2[len];
        return gcd(f[l][k], f[r - (1 << k) + 1][k]);
    }

    static boolean check(int m) {
        for (int i = 1; i + m <= n; ++i) {
            if (query(i, i + m) == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n + 1];
        int oneCnt = 0;
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
            if (a[i] == 1) ++oneCnt;
        }
        if (oneCnt > 0) {
            System.out.println(n - oneCnt);
            return;
        }
        init();
        if (query(1, n) != 1) {
            System.out.println(-1);
            return;
        }
        int l = 1, r = n - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        System.out.println(n + l - 1);
    }
}

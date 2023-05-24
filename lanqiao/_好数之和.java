import java.util.*;
import java.io.*;

public class _好数之和 {
    static final int N = 15;
    static int[] digits = new int[N], base = new int[N];
    static int len;
    static long[][][][][][] f = new long[N][N][N][N][2][2];

    static void init() {
        base[0] = 1;
        for (int i = 1; i < N; ++i) base[i] = base[i - 1] * 10;
    }

    static long[] dfs(int pos, int p, int pp, int ppp, int valid, boolean lim) {
        if (pos < 0) return valid == 1 ? new long[]{1L, 0L} : new long[2];
        if (!lim && f[pos][p][pp][ppp][valid][1] != 0) return f[pos][p][pp][ppp][valid];
        long[] res = new long[2];
        int up = lim ? digits[pos] : 9;
        for (int d = 0; d <= up; ++d) {
            int good = 0;
            if (ppp == 2 && pp == 0 && p == 2 && d == 2) good = 1;
            long[] tmp = dfs(pos - 1, d, p, pp, valid | good, lim && d == digits[pos]);
            res[0] += tmp[0];
            res[1] += tmp[1] + d * base[pos] * tmp[0];
        }
        return lim ? res : (f[pos][p][pp][ppp][valid] = res);
    }

    static long count(int n) {
        for (len = 0; n > 0; n /= 10) digits[len++] = n % 10;
        return dfs(len - 1, 0, 0, 0, 0, true)[1];
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt(), r = in.nextInt();
        init();
        System.out.println(count(r) - count(l - 1));
    }
}

import java.util.*;
import java.io.*;

public class M_异或三角 {
    static final int N = 35, K = 1 << 3;
    static int[] digits = new int[N];
    static int len;
    static long[][] f = new long[N][K];

    static long dfs(int pos, int state, boolean lim) {
        if (pos < 0) return state == 0b111 ? 1 : 0;
        if (!lim && f[pos][state] != -1) return f[pos][state];
        long res = 0;
        int up = lim ? digits[pos] : 1;
        for (int d = 0; d <= up; ++d) {
            if (d == 1) {
                res += dfs(pos - 1, state | 0b010, lim && d == digits[pos]) +
                       dfs(pos - 1, state | 0b100, lim && d == digits[pos]);
            } else {
                res += dfs(pos - 1, state, lim && d == digits[pos]);
                if (state >= 0b110) res += dfs(pos - 1, state | 0b001, lim && d == digits[pos]);
            }
        }
        return lim ? res : (f[pos][state] = res);
    }

    static long count(int n) {
        for (len = 0; n > 0; n >>= 1) digits[len++] = n & 1;
        for (long[] arr : f) Arrays.fill(arr, -1L);
        return dfs(len - 1, 0, true);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); int n = (int) in.nval;
            System.out.println(3L * count(n));
        }
    }
}

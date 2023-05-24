import java.util.*;
import java.io.*;

public class _小明数 {
    static final int N = 15;
    static int k;
    static int[] digits = new int[N];
    static long[][] memo = new long[N][N];

    static long dfs(int idx, int prev, boolean lim) {
        if (idx < 0) return 1L;
        if (!lim && memo[idx][prev] != -1) return memo[idx][prev];
        int up = lim ? digits[idx] : 9;
        long res = 0L;
        for (int x = 0; x <= up; ++x) {
            if (prev < 10 && Math.abs(x - prev) > k) continue;
            res += dfs(idx - 1, x, lim && x == up);
        }
        return memo[idx][prev] = res;
    }

    static long count(int x) {
        Arrays.fill(digits, 0);
        for (long[] arr : memo) Arrays.fill(arr, -1L);
        int len = 0;
        while (x > 0) {
            digits[len++] = x % 10;
            x /= 10;
        }
        return dfs(len, 10, true);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); k = (int) in.nval;
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            System.out.println(count(r) - count(l - 1));
        }
    }
}

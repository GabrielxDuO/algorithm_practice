import java.util.*;
import java.io.*;

public class J_二进制问题 {
    static final int N = 70;
    static long n;
    static int k;
    static int[] digits = new int[N];
    static long[][] f = new long[N][N];

    static long dfs(int pos, int cnt, boolean lim) {
        if (pos < 0) return cnt == k ? 1L : 0L;
        if (!lim && f[pos][cnt] != -1) return f[pos][cnt];
        int up = lim ? digits[pos] : 1;
        long res = 0L;
        for (int i = 0; i <= up; ++i) {
            res += dfs(pos - 1, cnt + (i == 1 ? 1 : 0), lim && i == up);
        }
        return f[pos][cnt] = res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextLong();
        k = in.nextInt();
        for (long[] arr : f) Arrays.fill(arr, -1L);
        int len = 0;
        long t = n;
        while (t > 0) {
            digits[len++] = (int) (t & 1);
            t >>= 1;
        }
        System.out.println(dfs(len, 0, true));
    }
}

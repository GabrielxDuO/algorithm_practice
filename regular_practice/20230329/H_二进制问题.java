import java.util.*;
import java.io.*;

public class H_二进制问题 {
    static final int N = 70;
    static long n;
    static int k;
    static int[] digits = new int[N];
    static long[][] f = new long[N][N];

    static long dfs(int idx, int cnt, boolean lim) {
        if (idx < 0) return cnt == k ? 1 : 0;
        if (!lim && f[idx][cnt] != -1) return f[idx][cnt];
        int up = lim ? digits[idx] : 1;
        long res = 0L;
        for (int i = 0; i <= up; ++i) {
            res += dfs(idx - 1, cnt + (i == 1 ? 1 : 0), lim && i == up);
        }
        return f[idx][cnt] = res;
    }

    static long count(long n) {
        for (int i = 0; i < N; ++i) Arrays.fill(f[i], -1L);
        int idx = 0;
        while (n > 0) {
            digits[idx++] = (int) (n & 1);
            n >>= 1;
        }
        System.out.println(Arrays.toString(digits));
        System.out.println(idx);
        return dfs(idx, 0, true);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextLong();
        k = in.nextInt();
        System.out.println(count(n));
    }
}

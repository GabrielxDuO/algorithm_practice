import java.util.*;
import java.io.*;

public class G_二进制问题 {
    static final int N = 70;
    static long n;
    static int k;
    static int[] digits = new int[N];
    static int len;
    static long[][] f = new long[N][N];

    static long dfs(int pos, int cnt, boolean lim) {
        if (pos < 0) return cnt == k ? 1 : 0;
        if (!lim && f[pos][cnt] != -1) return f[pos][cnt];
        long res = 0L;
        int up = lim ? digits[pos] : 1;
        for (int d = 0; d <= up; ++d) {
            res += dfs(pos - 1, cnt + d, lim && d == digits[pos]);
        }
        return lim ? res : (f[pos][cnt] = res);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextLong(); k = in.nextInt();
        for (len = 0; n > 0; n >>= 1) digits[len++] = (int) (n & 1);
        for (long[] arr : f) Arrays.fill(arr, -1L);
        System.out.println(dfs(len - 1, 0, true));
    }
}

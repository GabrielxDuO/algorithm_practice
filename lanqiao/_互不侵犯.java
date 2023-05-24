import java.util.*;
import java.io.*;

public class _互不侵犯 {
    static int lowbit(int x) { return x & -x; }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int m = 1 << n, len = 0;
        int[] states = new int[m];
        int[] cnts = new int[m];
        for (int x = 0; x < m; ++x) {
            if ((x & (x >> 1)) != 0) continue;
            states[len++] = x;
            int t = x, cnt = 0;
            while (t > 0) {
                t -= lowbit(t);
                ++cnt;
            }
            cnts[x] = cnt;
        }
        long[][][] f = new long[n + 1][m][k + 1];
        f[0][0][0] = 1L;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < len; ++j) {
                int curr = states[j];
                for (int s = cnts[curr]; s <= k; ++s) {
                    for (int l = 0; l < len; ++l) {
                        int prev = states[l];
                        if ((curr & prev) != 0 ||
                            (curr & (prev << 1)) != 0 ||
                            (curr & (prev >> 1)) != 0 ||
                            cnts[prev] > s - cnts[curr]) continue;
                        f[i][curr][s] += f[i - 1][prev][s - cnts[curr]];
                    }
                }
            }
        }
        long ans = 0L;
        for (int i = 0; i < len; ++i) ans += f[n][states[i]][k];
        System.out.println(ans);
    }
}

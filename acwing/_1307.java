import java.util.*;
import java.io.*;

public class _1307 {
    static final int MOD = 5000011;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        // f[i]表示考虑前i头牛且第i头牛是牡牛的方案数 s[i]是f[i]的前缀和
        // 状态转移方程: f[i] = sum(f[0], ..., f[max(0, i - k + 1)]) = s[max(0, i - k + 1)]
        int[] f = new int[n + 1], s = new int[n + 1];
        f[0] = s[0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i] = s[Math.max(i - k - 1, 0)];
            s[i] = (s[i - 1] + f[i]) % MOD;
        }
        System.out.println(s[n]);
    }
}

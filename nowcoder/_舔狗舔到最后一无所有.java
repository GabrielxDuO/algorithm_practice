import java.util.*;
import java.io.*;

public class _舔狗舔到最后一无所有 {
    static final int N = 100010;
    static final int MOD = (int) 1e9 + 7;

    static void solve(int n) {
        int[][] f = new int[N][3];
        f[1][0] = f[1][1] = f[1][2] = 1;
        f[2][0] = f[2][1] = f[2][2] = 3;
        for (int i = 3; i <= n; ++i) {
            f[i][0] = ((f[i - 1][1] + f[i - 2][2]) % MOD + 
                       (f[i - 1][2] + f[i - 2][1]) % MOD) % MOD;
            f[i][1] = ((f[i - 1][0] + f[i - 2][2]) % MOD + 
                       (f[i - 1][2] + f[i - 2][0]) % MOD) % MOD;
            f[i][2] = ((f[i - 1][0] + f[i - 2][1]) % MOD + 
                       (f[i - 1][1] + f[i - 2][0]) % MOD) % MOD;
        }
        int ans = 0;
        for (int i = 0; i < 3; ++i) {
            ans = (ans + f[n][i]) % MOD;
        }
        System.out.println(ans);
    }

    static void solve1(int n) {
        int[] f = new int[N];
        f[1] = 3;
        f[2] = 9;
        for (int i = 3; i <= n; ++i) {
            f[i] = (f[i - 1] * 2 % MOD + f[i - 2] * 2 % MOD) % MOD;
        }
        System.out.println(f[n]);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); int n = (int) in.nval;
            // solve(n);
            solve1(n);
        }
    }
}

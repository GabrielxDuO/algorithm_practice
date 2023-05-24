import java.util.*;
import java.io.*;

public class _最长公共子序列 {
    static final int MOD = (int) 1e8;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] a = ('\0' + in.readLine()).toCharArray();
        char[] b = ('\0' + in.readLine()).toCharArray();
        int n = a.length - 2, m = b.length - 2;
        int[][] f = new int[2][m + 1], g = new int[2][m + 1];
        // Arrays.fill(g[0], 1);
        for(int i=0;i<m;i++) g[0][i]=1;
        g[1][0]=1;
        int curr = 0;
        for (int i = 1; i <= n; ++i, curr ^= 1) {
            for (int j = 1; j <= m; ++j) {
                f[curr ^ 1][j] = 0;
                if (a[i] == b[j])
                {
                    f[curr ^ 1][j] = f[curr][j - 1] + 1;
                    g[curr ^ 1][j] += g[curr][j - 1];
                }
                else
                {
                    f[curr ^ 1][j] = Math.max(f[curr][j], f[curr ^ 1][j - 1]);
                }

                if (f[curr ^ 1][j] == f[curr ^ 1][j - 1])
                {
                    g[curr ^ 1][j] += g[curr ^ 1][j - 1];
                }
                if (f[curr ^ 1][j] == f[curr][j])
                {
                    g[curr ^ 1][j] += g[curr][j];
                }
                if (a[1] != b[1] && f[curr ^ 1][j] == f[curr][j - 1])
                {
                    g[curr ^ 1][j] -= g[curr][j - 1];
                }
                g[curr ^ 1][j] = g[curr ^ 1][j] % MOD;
                // f[curr][j] = Math.max(f[curr ^ 1][j], f[curr][j - 1]);
                // g[curr][j] = 0;
                // if (a[i] == b[j]) {
                //     f[curr][j] = Math.max(f[curr][j], f[curr ^ 1][j - 1] + 1);
                //     if (f[curr][j] == f[curr ^ 1][j - 1] + 1) g[curr][j] += g[curr ^ 1][j - 1];
                // } else {
                //     if (f[curr][j] == f[curr ^ 1][j - 1]) g[curr][j] -= g[curr ^ 1][j - 1];
                // }
                // if (f[curr][j] == f[curr ^ 1][j]) g[curr][j] = (g[curr][j] + g[curr ^ 1][j]) % MOD;
                // if (f[curr][j] == f[curr][j - 1]) g[curr][j] = (g[curr][j] + g[curr][j - 1]) % MOD;
            }
        }
        System.out.println(f[curr][m]);
        System.out.println(g[curr][m]);
    }
}

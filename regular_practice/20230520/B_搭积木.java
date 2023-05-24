import java.util.*;
import java.io.*;

public class B_搭积木 {
    static final int MOD = (int) 1e9 + 7;
    static int n, m;
    static char[][] g;
    static long[][][] f;

    static long dfs(int u, int l, int r) {
        if (u == 0) return 1;
        if (f[u][l][r] != -1L) return f[u][l][r];
        long res = 1L;
        for (int i = l; i <= r; ++i) {
            if (g[u][i] == 'X') continue;
            for (int j = i; j <= r && g[u][j] != 'X'; ++j) {
                res = (res + dfs(u - 1, i, j)) % MOD;
            }
        }
        return f[u][l][r] = res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        in.nextLine();
        g = new char[n + 1][m];
        for (int i = 1; i <= n; ++i) g[i] = in.nextLine().toCharArray();
        f = new long[n + 1][m][m];
        for (long[][] mat : f) {
            for (long[] arr : mat) Arrays.fill(arr, -1L);
        }
        dfs(n, 0, m - 1);
        System.out.println(f[n][0][m - 1]);
    }
}

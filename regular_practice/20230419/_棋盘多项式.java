import java.util.*;
import java.io.*;

public class _棋盘多项式 {
    static int n;
    static int[][] g;
    static boolean[][] has;
    static int[] cnts;
    static int mx;

    static boolean check(int x, int y) {
        if (g[x][y] == 0 || has[x][y]) return false;
        for (int i = x - 1; i >= 0 && g[i][y] == 1; --i) {
            if (has[i][y]) return false;
        }
        for (int j = y - 1; j >= 0 && g[x][j] == 1; --j) {
            if (has[x][j]) return false;
        }
        return true;
    }

    static void dfs(int r, int c, int cnt) {
        mx = Math.max(mx, cnt);
        ++cnts[cnt];
        for (int i = r; i < n; ++i) {
            for (int j = (i == r ? c : 0); j < n; ++j) {
                if (check(i, j)) {
                    has[i][j] = true;
                    dfs(i, j, cnt + 1);
                    has[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                in.nextToken(); g[i][j] = (int) in.nval;
            }
        }
        has = new boolean[n][n];
        cnts = new int[n * n];
        dfs(0, 0, 0);
        for (int i = 1; i <= mx; ++i) System.out.println(cnts[i]);
    }
}

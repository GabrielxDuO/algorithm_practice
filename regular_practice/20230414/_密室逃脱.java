import java.util.*;
import java.io.*;

public class _密室逃脱 {
    static final int[][] DIRS = {{0, 2}, {1, 1}, {3, 0}};
    static final char[] DIRCS = {'r', 'g', 'b'};
    static int n, m;
    static StringBuilder path = new StringBuilder();
    static int[][] g;
    static boolean found = false;

    static void dfs(int x, int y, int[] maho) {
        if (found) return;
        if (x == n - 1 && y == m - 1) {
            System.out.println(path);
            found = true;
            return;
        }
        for (int i = 0; i < 3; ++i) {
            if (maho[i] == 0) continue;
            int nx = x + DIRS[i][0], ny = y + DIRS[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == 0) continue;
            --maho[i];
            path.append(DIRCS[i]);
            dfs(nx, ny, maho);
            path.deleteCharAt(path.length() - 1);
            ++maho[i];
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); int a = (int) in.nval;
        in.nextToken(); int b = (int) in.nval;
        in.nextToken(); int c = (int) in.nval;
        g = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                in.nextToken(); g[i][j] = (int) in.nval;
            }
        }
        dfs(0, 0, new int[]{a, b, c});
        if (!found) System.out.println(-1);
    }
}

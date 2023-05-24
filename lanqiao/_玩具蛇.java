import java.util.*;
import java.io.*;

public class _玩具蛇 {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n = 4;
    static boolean[][] used = new boolean[n][n];
    static int ans = 0;

    static void dfs(int u, int x, int y) {
        if (u == 16) {
            ++ans;
            return;
        }
        for (int[] DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || used[nx][ny]) continue;
            used[nx][ny] = true;
            dfs(u + 1, nx, ny);
            used[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                used[i][j] = true;
                dfs(1, i, j);
                used[i][j] = false;
            }
        }
        System.out.println(ans);
    }
}

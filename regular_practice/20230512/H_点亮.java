import java.util.*;
import java.io.*;

public class H_点亮 {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n;
    static char[][] g;

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static int count(int x, int y) {
        int cnt = 0;
        for (int[] DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (g[nx][ny] == 'O') ++cnt;
        }
        return cnt;
    }

    static boolean check(int x, int y) {
        for (int[] DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            while (nx >= 0 && nx < n && ny >= 0 && ny < n && g[nx][ny] != 'X' && !isDigit(g[nx][ny])) {
                if (g[nx][ny] == 'O') return true;
                nx += DIR[0];
                ny += DIR[1];
            }
        }
        return false;
    }

    static void dfs(int pos) {
        int x = pos / n, y = pos % n;
        if (pos == n * n) {
            for (x = 0; x < n; ++x) {
                for (y = 0; y < n; ++y) {
                    if (g[x][y] == '.' && !check(x, y)) return;
                    if (g[x][y] == 'O' && check(x, y)) return;
                    if (isDigit(g[x][y]) && g[x][y] - '0' != count(x, y)) return;
                }
            }
            for (char[] arr : g) {
                for (char c : arr) System.out.print(c);
                System.out.println();
            }
            return;
        }
        if (g[x][y] == '.') {
            if (!check(x, y)) {
                g[x][y] = 'O';
                dfs(pos + 1);
                g[x][y] = '.';
            }
        } else if (isDigit(g[x][y])) {
            if (count(x, y) + 2 < g[x][y] - '0' || count(x, y) > g[x][y] - '0') return;
        }
        dfs(pos + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); n = (int) in.nval;
        g = new char[n][n];
        for (int i = 0; i < n; ++i) g[i] = br.readLine().toCharArray();
        dfs(0);
    }
}

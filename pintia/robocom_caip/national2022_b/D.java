import java.util.*;
import java.io.*;

public class D {
    static final int[][] DIRS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static int n, m;
    static char[][] g;
    static char[] s;
    static int len;
    static boolean[][] used;

    static boolean dfs(int x, int y, int u) {
        if (u == len - 1) return true;
        for (int[] DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || used[nx][ny] || g[nx][ny] != s[u + 1]) continue;
            used[nx][ny] = true;
            if (dfs(nx, ny, u + 1)) return true;
            used[nx][ny] = false;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        br.readLine();
        g = new char[n][m];
        used = new boolean[n][m];
        for (int i = 0; i < n; ++i) g[i] = br.readLine().toCharArray();
        s = br.readLine().toCharArray();
        len = s.length;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (g[i][j] == s[0]) {
                    used[i][j] = true;
                    if (dfs(i, j, 0)) {
                        for (int x = 0; x < n; ++x) {
                            for (int y = 0; y < m; ++y) {
                                ans.append(used[x][y] ? g[x][y] : '.');
                            }
                            ans.append('\n');
                        }
                        out.print(ans);
                        out.flush();
                        out.close();
                    }
                    used[i][j] = false;
                }
            }
        }
    }
}
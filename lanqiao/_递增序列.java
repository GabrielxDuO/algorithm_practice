import java.util.*;
import java.io.*;

public class _递增序列 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        char[][] g = new char[n][m];
        for (int i = 0; i < n; ++i) g[i] = in.nextLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int x = i + 1; x < n; ++x) {
                    if (g[x][j] > g[i][j]) {
                        // System.out.println(g[i][j] + "" + g[x][j]);
                        ++cnt;
                    }
                }
                for (int y = j + 1; y < m; ++y) {
                    if (g[i][y] > g[i][j]) {
                        // System.out.println(g[i][j] + "" + g[i][y]);
                        ++cnt;
                    }
                }
                for (int x = i + 1, y = j + 1; x < n && y < m; ++x, ++y) {
                    if (g[x][y] > g[i][j]) {
                        // System.out.println(g[i][j] + "" + g[x][y]);
                        ++cnt;
                    }
                }
                for (int x = i + 1, y = j - 1; x < n && y >= 0; ++x, --y) {
                    if (g[x][y] > g[i][j]) {
                        // System.out.println(g[i][j] + "" + g[x][y]);
                        ++cnt;
                    }
                }
                for (int x = i - 1, y = j + 1; x >= 0 && y < m; --x, ++y) {
                    if (g[x][y] > g[i][j]) {
                        // System.out.println(g[i][j] + "" + g[x][y]);
                        ++cnt;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

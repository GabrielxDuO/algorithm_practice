import java.util.*;
import java.io.*;

public class _扫雷 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] g = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                g[i][j] = in.nextInt();
            }
        }
        int[][] a = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (g[i][j] == 1) { a[i][j] = 9; continue; }
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x == i && y == j) continue;
                        if (x < 0 || x >= n || y < 0 || y >= m || g[x][y] == 0) continue;
                        ++a[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

import java.util.*;
import java.io.*;

public class _兰顿蚂蚁 {
    static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] mp = new int[256];
    static {
        mp['U'] = 0;
        mp['R'] = 1;
        mp['D'] = 2;
        mp['L'] = 3;
    }
    static int n, m;
    static boolean[][] g;
    static int x, y;
    static int s, k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        g = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                g[i][j] = in.nextInt() == 0 ? false : true;
            }
        }
        x = in.nextInt(); y = in.nextInt();
        s = mp[in.next().charAt(0)]; k = in.nextInt();
        while (k-- > 0) {
            if (g[x][y]) {
                if (++s == 4) s = 0;
            } else {
                if (--s == -1) s = 3;
            }
            g[x][y] = !g[x][y];
            x += DIRS[s][0];
            y += DIRS[s][1];
            if (x >= n) --x;
            else if (x < 0) ++x;
            if (y >= m) --y;
            else if (y < 0) ++y;
        }
        System.out.println(x + " " + y);
    }
}

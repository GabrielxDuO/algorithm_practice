import java.util.*;
import java.io.*;

public class _大胖子走迷宫 {
    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n, k;
    static char[][] g;
    static int m = 2, time = 0;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        g = new char[n + 1][n + 1];
        vis = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) g[i] = ('\0' + br.readLine()).toCharArray();
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{3, 3});
        vis[3][3] = true;
        while (!que.isEmpty()) {
            int sz = que.size();
            if (time == k || time == k * 2) --m;
            while (sz-- > 0) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1];
                if (Math.abs(x - (n - 2)) <= m && Math.abs(y - (n - 2)) <= m) {
                    System.out.println(time);
                    return;
                }
                if (m > 0) que.offer(new int[]{x, y});
                outer: for (int[] DIR : DIRS) {
                    int nx = x + DIR[0], ny = y + DIR[1];
                    if (nx - m < 1 || nx + m > n || ny - m < 1 || ny + m > n || vis[nx][ny]) continue;
                    for (int i = nx - m; i <= nx + m; ++i) {
                        for (int j = ny - m; j <= ny + m; ++j) {
                            if (g[i][j] == '*') continue outer;
                        }
                    }
                    que.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            ++time;
        }
    }
}

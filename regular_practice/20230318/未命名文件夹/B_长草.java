import java.util.*;
import java.io.*;

public class Main {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        char[][] g = new char[n][m];
        Queue<int[]> que = new LinkedList<>();
        in.nextLine();
        for (int i = 0; i < n; ++i) {
            g[i] = in.nextLine().toCharArray();
            for (int j = 0; j < m; ++j) {
                if (g[i][j] == 'g') que.offer(new int[]{i, j});
            }
        }
        int k = in.nextInt(), step = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1];
                for (int[] DIR : DIRS) {
                    int nx = x + DIR[0], ny = y + DIR[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == 'g') continue;
                    que.offer(new int[]{nx, ny});
                    g[nx][ny] = 'g';
                }
            }
            if (++step == k) break;
        }
        for (int i = 0; i < n; ++i) System.out.println(String.valueOf(g[i]));
    }
}

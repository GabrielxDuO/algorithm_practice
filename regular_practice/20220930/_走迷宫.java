import java.util.*;
import java.io.*;

public class _走迷宫 {
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;
    static boolean[][] g;
    static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        g = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                in.nextToken();
                g[i][j] = in.nval == 1.0;
            }
        }
        in.nextToken();
        x1 = (int) in.nval - 1;
        in.nextToken();
        y1 = (int) in.nval - 1;
        in.nextToken();
        x2 = (int) in.nval - 1;
        in.nextToken();
        y2 = (int) in.nval - 1;
        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][] vis = new boolean[n][m];
        vis[x1][y1] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x1, y1, 0});
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int x = curr[0], y = curr[1], step = curr[2];
            if (x == x2 && y == y2) return step;
            for (int[] d : DIRECTIONS) {
                int newX = x + d[0], newY = y + d[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m
                    || !g[newX][newY] || vis[newX][newY]) continue;
                que.offer(new int[]{newX, newY, step + 1});
                vis[newX][newY] = true;
            }
        }
        return -1;
    }
}

import java.util.*;
import java.io.*;

public class _走迷宫2 {
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;
    static char[][] g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        g = new char[n][m];
        for (int i = 0; i < n; ++i) {
            g[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs());
    }

    static int bfs() {
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 1});
        vis[0][0] = true;
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int x = curr[0], y = curr[1], step = curr[2];
            if (x == n - 1 && y == m - 1) return step;
            for (int[] d : DIRECTIONS) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m
                    || g[nx][ny] == '#' || vis[nx][ny]) continue;
                que.offer(new int[]{nx, ny, step + 1});
                vis[nx][ny] = true;
            }
        }
        return -1;
    }
}

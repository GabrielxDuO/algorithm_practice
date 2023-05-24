import java.util.*;
import java.io.*;

public class _怪物森林 {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;
    static long[][] g;
    static boolean[][] vis;

    static class State {
        int x, y;
        long imp;

        public State(int x, int y, long imp) {
            this.x = x;
            this.y = y;
            this.imp = imp;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        g = new long[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                g[i][j] = in.nextLong();
            }
        }
        vis = new boolean[n][m];
        vis[0][0] = true;
        Queue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(b.imp, a.imp));
        pq.offer(new State(0, 0, g[0][0]));
        while (!pq.isEmpty()) {
            State s = pq.poll();
            int x = s.x, y = s.y;
            if (x == n - 1 && y == m - 1) {
                System.out.println(s.imp);
                return;
            }
            for (int[] DIR : DIRS) {
                int nx = x + DIR[0], ny = y + DIR[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) continue;
                vis[nx][ny] = true;
                pq.offer(new State(nx, ny, Math.min(s.imp, g[nx][ny])));
            }
        }
    }
}

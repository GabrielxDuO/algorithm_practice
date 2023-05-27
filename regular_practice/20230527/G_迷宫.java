import java.util.*;
import java.io.*;

public class G_迷宫 {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;
    static List<int[]>[][] ps;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        ps = new ArrayList[n + 1][n + 1];
        while (m-- > 0) {
            in.nextToken(); int x1 = (int) in.nval;
            in.nextToken(); int y1 = (int) in.nval;
            in.nextToken(); int x2 = (int) in.nval;
            in.nextToken(); int y2 = (int) in.nval;
            if (ps[x1][y1] == null) ps[x1][y1] = new ArrayList<>();
            if (ps[x2][y2] == null) ps[x2][y2] = new ArrayList<>();
            ps[x1][y1].add(new int[]{x2, y2});
            ps[x2][y2].add(new int[]{x1, y1});
        }
        vis = new boolean[n + 1][n + 1];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{n, n});
        vis[n][n] = true;
        int step = 0;
        double sum = 0.0;
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1];
                sum += step;
                for (int[] DIR : DIRS) {
                    int nx = x + DIR[0], ny = y + DIR[1];
                    if (nx <= 0 || nx > n || ny <= 0 || ny > n || vis[nx][ny]) continue;
                    que.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
                if (ps[x][y] != null) {
                    for (int[] pos : ps[x][y]) {
                        int nx = pos[0], ny = pos[1];
                        if (vis[nx][ny]) continue;
                        que.offer(new int[]{nx, ny});
                        vis[nx][ny] = true;
                    }
                }
            }
            ++step;
        }
        System.out.printf("%.2f\n", sum / (n * n));
    }
}

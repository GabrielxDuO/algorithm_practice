import java.util.*;
import java.io.*;

public class _2222迷宫 {
    static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;
    static List<int[]>[][] pts;
    static int[][] dists;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        pts = new ArrayList[n + 1][n + 1];
        while (m-- > 0) {
            int x1 = in.nextInt(), y1 = in.nextInt();
            int x2 = in.nextInt(), y2 = in.nextInt();
            if (pts[x1][y1] == null) pts[x1][y1] = new ArrayList<>();
            if (pts[x2][y2] == null) pts[x2][y2] = new ArrayList<>();
            pts[x1][y1].add(new int[]{x2, y2});
            pts[x2][y2].add(new int[]{x1, y1});
        }
        dists = new int[n + 1][n + 1];
        for (int[] arr : dists) Arrays.fill(arr, -1);
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{n, n});
        dists[n][n] = 0;
        int d = 1;
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1];
                for (int[] DIR : DIRS) {
                    int nx = x + DIR[0], ny = y + DIR[1];
                    if (nx <= 0 || nx > n || ny <= 0 || ny > n || dists[nx][ny] != -1) continue;
                    dists[nx][ny] = d;
                    que.offer(new int[]{nx, ny});
                }
                if (pts[x][y] != null) {
                    for (int[] pos : pts[x][y]) {
                        int nx = pos[0], ny = pos[1];
                        if (dists[nx][ny] != -1) continue;
                        dists[nx][ny] = d;
                        que.offer(pos);
                    }
                }
            }
            ++d;
        }
        double sum = 0.0;
        for (int x = 1; x <= n; ++x) {
            for (int y = 1; y <= n; ++y) sum += dists[x][y];
        }
        System.out.printf("%.2f\n", sum / (n * n));
    }
}

import java.util.*;
import java.io.*;

public class _全球变暖 {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n;
    static char[][] g;
    static boolean[][] vis;

    static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        vis[x][y] = true;
        boolean disapper = true;
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            x = curr[0]; y = curr[1];
            boolean fade = false;
            for (int[] DIR : DIRS) {
                int nx = x + DIR[0], ny = y + DIR[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (g[nx][ny] == '.') { fade = true; continue; }
                if (vis[nx][ny]) continue;
                vis[nx][ny] = true;
                que.offer(new int[]{nx, ny});
            }
            if (!fade) disapper = false;
        }
        return disapper ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); n = (int) in.nval;
        g = new char[n][n]; 
        vis = new boolean[n][n]; 
        for (int i = 0; i < n; ++i) g[i] = br.readLine().toCharArray();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!vis[i][j] && g[i][j] == '#') ans += bfs(i, j);
            }
        }
        System.out.println(ans);
    }
}

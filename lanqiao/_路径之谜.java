import java.util.*;
import java.io.*;

public class _路径之谜 {
    static final int[][] DIRS = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int n;
    static int[] rows, cols;
    static boolean[][] vis;
    static int[] prevs;

    static void dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            for (int e : rows) if (e != 0) return;
            for (int e : cols) if (e != 0) return;
            Deque<Integer> stk = new LinkedList<>();
            for (int i = n * n - 1; i != -1; i = prevs[i]) stk.push(i);
            while (!stk.isEmpty()) System.out.print(stk.pop() + " ");
            System.out.println();
            return;
        }
        int pos = x * n + y;
        for (int[] DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || vis[nx][ny]) continue;
            if (rows[nx] <= 0 || cols[ny] <= 0) continue;
            vis[nx][ny] = true;
            --rows[nx]; --cols[ny];
            prevs[nx * n + ny] = pos;
            dfs(nx, ny);
            vis[nx][ny] = false;
            ++rows[nx]; ++cols[ny];
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        rows = new int[n]; cols = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); cols[i] = (int) in.nval;
        }
        for (int i = 0; i < n; ++i) {
            in.nextToken(); rows[i] = (int) in.nval;
        }
        vis = new boolean[n][n];
        --rows[0]; --cols[0];
        vis[0][0] = true;
        prevs = new int[n * n];
        prevs[0] = -1;
        dfs(0, 0);
    }
}

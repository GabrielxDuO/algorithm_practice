import java.util.*;
import java.io.*;

public class _路经之谜 {
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n;
    static int[] rows, cols;
    static boolean[] vis;
    static Deque<Integer> path = new LinkedList<>();
    static boolean hasAns = false;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        rows = new int[n];
        cols = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            cols[i] = (int) in.nval;
        }
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            rows[i] = (int) in.nval;
        }
        vis = new boolean[n * n];
        dfs(0, 0);
    }

    static void dfs(int x, int y) {
        if (hasAns) return;
        --rows[x];
        --cols[y];
        int curr = x * n + y;
        vis[curr] = true;
        path.offer(curr);
        if (rows[x] < 0 || cols[y] < 0) return;
        if (curr == n * n - 1) {
            for (int i = 0; i < n; ++i) {
                if (rows[i] != 0 || cols[i] != 0) return;
            }
            StringBuilder ans = new StringBuilder();
            while (!path.isEmpty()) {
                ans.append(" ").append(path.poll());
            }
            System.out.println(ans.substring(1));
            hasAns = true;
            return;
        }
        for (int[] d : DIRECTIONS) {
            int nx = x + d[0], ny = y + d[1];
            int next = nx * n + ny;
            if (nx < 0 || nx >= n || ny < 0 || ny >= n ||
                vis[next] || rows[nx] <= 0 || cols[ny] <= 0) continue;
            dfs(nx, ny);
            vis[next] = false;
            path.pollLast();
            ++rows[nx];
            ++cols[ny];
        }
    }
}

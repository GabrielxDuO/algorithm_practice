import java.util.*;
import java.io.*;

public class _长草_BFS {
    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;
    static char[][] g;
    static int k;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(Reader.next());
        m = Integer.parseInt(Reader.next());
        g = new char[n][m];
        for (int i = 0; i < n; ++i) {
            g[i] = Reader.nextLine().toCharArray();
        }
        k = Integer.parseInt(Reader.next());
        bfs();
        StringBuilder ans = new StringBuilder();
        for (char[] line : g) {
            ans.append(String.valueOf(line)).append("\n");
        }
        System.out.print(ans);
    }

    static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (g[i][j] == 'g') que.offer(new int[]{i, j, 0});
            }
        }
        while (!que.isEmpty()) {
            int[] state = que.poll();
            int cnt = state[2];
            if (cnt++ < k) {
                for (int[] d : DIRECTIONS) {
                    int nx = state[0] + d[0], ny = state[1] + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == 'g') continue;
                    g[nx][ny] = 'g';
                    que.offer(new int[]{nx, ny, cnt});
                }
            }
        }
    }

    static class Reader {
        static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer in = new StringTokenizer("");

        static String next() throws IOException {
            while (!in.hasMoreTokens()) {
                in = new StringTokenizer(BR.readLine());
            }
            return in.nextToken();
        }

        static String nextLine() throws IOException { return BR.readLine(); }
    }
}

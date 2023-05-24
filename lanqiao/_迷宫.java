import java.util.*;
import java.io.*;

public class _迷宫 {
    static final int[][] DIRS = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static final char[] DIRCS = {'D', 'L', 'R', 'U'};
    static int n, m;
    static char[][] g;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());
        g = new char[n][m];
        for (int i = 0; i < n; ++i) g[i] = in.readLine().toCharArray();
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        g[0][0] = '1';
        int[][][] prevs = new int[n][m][3];
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1];
                if (x == n - 1 && y == m - 1) {
                    StringBuilder ans = new StringBuilder();
                    while (x != 0 || y != 0) {
                        int[] prev = prevs[x][y];
                        ans.append(DIRCS[prev[2]]);
                        x = prev[0]; y = prev[1];
                    }
                    System.out.println(ans.reverse());
                    return;
                }
                for (int i = 0; i < 4; ++i) {
                    int nx = x + DIRS[i][0], ny = y + DIRS[i][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == '1') continue;
                    que.offer(new int[]{nx, ny});
                    g[nx][ny] = '1';
                    prevs[nx][ny] = new int[]{x, y, i};
                }
            }
        }
        // System.out.println("DDDDRRURRRRRRDRRRRDDDLDDRDDDDDDDDDDDDRDDRRRURRUURRDDDDRDRRRRRRDRRURRDDDRRRRUURUUUUUUULULLUUUURRRRUULLLUUUULLUUULUURRURRURURRRDDRRRRRDDRRDDLLLDDRRDDRDDLDDDLLDDLLLDLDDDLDDRRRRRRRRRDDDDDDRR");
    }
}

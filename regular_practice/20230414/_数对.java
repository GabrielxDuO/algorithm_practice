import java.util.*;
import java.io.*;

public class _数对 {
    static int a, b, c, d;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        a = in.nextInt(); b = in.nextInt();
        c = in.nextInt(); d = in.nextInt();
        Queue<int[]> que = new LinkedList<>();
        boolean[][] vis = new boolean[110][110];
        que.offer(new int[]{a, b});
        vis[a][b] = true;
        int step = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                int[] curr = que.poll();
                a = curr[0]; b = curr[1];
                if (a == c && b == d) {
                    System.out.println(step);
                    return;
                }
                int x = (a + b) % 100, y = gcd(a, b);
                if (!vis[x][b]) {
                    que.offer(new int[]{x, b});
                    vis[x][b] = true;
                }
                if (!vis[a][x]) {
                    que.offer(new int[]{a, x});
                    vis[a][x] = true;
                }
                if (!vis[y][b]) {
                    que.offer(new int[]{y, b});
                    vis[y][b] = true;
                }
                if (!vis[a][y]) {
                    que.offer(new int[]{a, y});
                    vis[a][y] = true;
                }
            }
            ++step;
        }
        System.out.println(-1);
    }
}

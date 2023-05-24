import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static double d;

    static double getSquDist(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        d = in.nextDouble();
        double sd = d * d;
        Queue<int[]> que = new LinkedList<>();
        boolean[][] vis = new boolean[n + 1][m + 1];
        que.offer(new int[]{1, 1});
        vis[1][1] = true;
        int step = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                int[] curr = que.poll();
                int x = curr[0], y = curr[1];
                if (x == n && y == m) {
                    System.out.println(step);
                    return;
                }
                double mn = Integer.MAX_VALUE;
                List<int[]> mns = new ArrayList<>();
                outer: for (int nx = x; nx <= x + d; ++nx) {
                    for (int ny = y; ny <= y + d; ++ny) {
                        if (nx > n || ny > m || vis[nx][ny]) continue;
                        double fd = getSquDist(x, y, nx, ny);
                        if (fd > sd) continue;
                        double td = getSquDist(n, m, nx, ny);
                        vis[nx][ny] = true;
                        if (td == mn) mns.add(new int[]{nx, ny});
                        else if (td < mn) {
                            mn = td;
                            mns.clear();
                            mns.add(new int[]{nx, ny});
                        }
                    }
                }
                for (int[] pos : mns) {
                    que.offer(new int[]{pos[0], pos[1]});
                }       
            }
            ++step;
        }
    }
}

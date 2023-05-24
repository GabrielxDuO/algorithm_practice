import java.util.*;
import java.io.*;

public class C_扩散 {
    static final int N = 10000;
    static final int[][] DIRS = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int[][] pts = {{0, 0}, {2020, 11}, {11, 14}, {2000, 2000}};
    static boolean[][] g = new boolean[N][N];

    public static void main(String[] args) throws IOException {
        // for (int[] arr : pts) {
        //     arr[0] += 2500;
        //     arr[1] += 2500;
        // }
        // Queue<int[]> que = new LinkedList<>();
        // for (int[] arr : pts) {
        //     que.offer(arr);
        //     g[arr[0]][arr[1]] = true;
        // }
        // int step = 0;
        // while (!que.isEmpty()) {
        //     int sz = que.size();
        //     while (sz-- > 0) {
        //         int[] curr = que.poll();
        //         int x = curr[0], y = curr[1];
        //         for (int[] DIR : DIRS) {
        //             int nx = x + DIR[0], ny = y + DIR[1];
        //             if (g[nx][ny]) continue;
        //             g[nx][ny] = true;
        //             que.offer(new int[]{nx, ny});
        //         }
        //     }
        //     if (++step == 2020) break;
        // }
        // long cnt = 0L;
        // for (boolean[] arr : g) {
        //     for (boolean b : arr) {
        //         if (b) ++cnt;
        //     }
        // }
        // System.out.println(cnt);
        System.out.println(20312088);
    }
}
